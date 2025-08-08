package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.RabbitMQProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMQProducerServiceImpl implements RabbitMQProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishMessageToRabbitMQ(String errorExchange, String routingKey, Message message) {
        rabbitTemplate.send(errorExchange, "", message);
        LogUtil.info(log, "RabbitMQServiceImpl.publishMessageToRabbitMQ: Message published to exchange: {}", errorExchange);
    }
}
