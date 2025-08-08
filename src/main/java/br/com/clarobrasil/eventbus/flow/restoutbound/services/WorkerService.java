package br.com.clarobrasil.eventbus.flow.restoutbound.services;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.utils.WorkerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

import static br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants.ERROR_WORKER_RETRY;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkerService {

    @Value("${app.request.max-retry-attempts}")
    private Integer maxRetryAttempts;

    @Value("${app.request.retry-interval}")
    private Integer retryInterval;

    @Value("${app.request.retry-enabled}")
    private boolean retry;

    @Value("${app.rabbitmq.error-exange}")
    private String errorExchange;

    private final ReactiveSenderService reactiveSenderService;

    private final RabbitMQProducerService rabbitMQService;

    private final WorkerUtils workerUtils;

    public boolean processMessage(Message message) {

        MessageProperties properties = message.getMessageProperties();
        HttpHeaders headers = new HttpHeaders();
        properties.getHeaders().forEach((key, value) ->
                headers.add(key, value.toString())
        );

        Object headerValue = properties.getHeader("x-delivery-count");
        int xDeliveryCount = headerValue == null ? 1 : ((Long) headerValue).intValue();

        String messageId = properties.getHeader("message-id");

        String body = new String(message.getBody(), StandardCharsets.UTF_8);
        LogUtil.info(log, "WorkerService.processMessage: Mensagem recebida: " + body);


        Mono<String> response;
        try {
            if (xDeliveryCount == 1) {
                response = reactiveSenderService.sendRequest(headers, body);
            } else if (xDeliveryCount <= maxRetryAttempts && retry) {
                Thread.sleep(retryInterval);
                LogUtil.info(log, "WorkerService.processMessage: Retrying send message attempt: {}", xDeliveryCount);
                response = reactiveSenderService.sendRequest(headers, body);
            } else {
                var errorRabbitMessage = workerUtils.receivedMessageToErrorMessage(message, ERROR_WORKER_RETRY);
                rabbitMQService.publishMessageToRabbitMQ(errorExchange, "", errorRabbitMessage);
                LogUtil.info(log, "WorkerService.processMessage: Removing message after maximum attempts, the message-id is: {}", messageId);
                return true;
            }
        } catch (InterruptedException e) {
            LogUtil.error(log, "WorkerService.processMessage: Error when retrying to send message: {}", e.getMessage());
            Thread.currentThread().interrupt();
            return false;
        }

        try {
            String res = response.block();
            LogUtil.info(log, "WorkerService.processMessage: Response for request is : {}, status code: {} ", res);
            return true;
        } catch (Exception e) {
            if (xDeliveryCount < maxRetryAttempts && retry) {
                LogUtil.error(log, "WorkerService.processMessage: Unable to send request to apigee: {}", e.getMessage());
                return false;
            } else {
                LogUtil.error(log, "WorkerService.processMessage: Unable to send request to apigee: {}", e.getMessage());
                var errorRabbitMessage = workerUtils.receivedMessageToErrorMessage(message, e.getMessage());
                rabbitMQService.publishMessageToRabbitMQ(errorExchange, "", errorRabbitMessage);
                LogUtil.info(log, "WorkerService.processMessage: Unable to send message-id: {} to apigee, remove message after get error: {}", messageId, e.getMessage());
                return true;
            }
        }

    }
}
