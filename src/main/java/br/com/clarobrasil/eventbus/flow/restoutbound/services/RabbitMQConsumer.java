package br.com.clarobrasil.eventbus.flow.restoutbound.services;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

public interface RabbitMQConsumer {

    void consume(Message message, Channel channel, long tag);
}
