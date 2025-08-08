package br.com.clarobrasil.eventbus.flow.restoutbound.services;

import org.springframework.amqp.core.Message;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

public interface RabbitMQProducerService {

    void publishMessageToRabbitMQ(String errorExchange, String routingKey, Message message);
}
