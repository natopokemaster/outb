package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.RabbitMQConsumer;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.WorkerService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitMQConsumerImpl implements RabbitMQConsumer {

    private final WorkerService workerService;

    @RabbitListener(queues = "${app.rabbitmq.queue}", containerFactory = "simpleRabbitListenerContainerFactory")
    public void consume(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            if (workerService.processMessage(message)) {
                channel.basicAck(tag, false);
                LogUtil.info(log, "RabbitMQConsumerImpl.consume: Message with id {} was acknowledged.", Optional.ofNullable(message.getMessageProperties().getHeader("message-id")).get());
            } else {
                channel.basicNack(tag, false, true);
                LogUtil.info(log, "RabbitMQConsumerImpl.consume: Message not acknowledged, requeued");
            }
        } catch (Exception e) {
            LogUtil.error(log, "RabbitMQConsumerImpl.consume: Error processing message", e);
            try {
                channel.basicNack(tag, false, true);
            } catch (Exception ex) {
                LogUtil.error(log, "RabbitMQConsumerImpl.consume: Unable to NACK message", ex);
            }
        }
    }
}
