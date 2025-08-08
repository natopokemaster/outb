package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RabbitMQProducerServiceImplTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @Mock
    private Slf4j log;

    @InjectMocks
    private RabbitMQProducerServiceImpl rabbitMQProducerService;

    @Test
    void testPublishMessageToRabbitMQ_RabbitMQException() {
        // Given
        String exchange = "test-exchange";
        String routingKey = "test-routing-key";
        Message message = new Message("test-message".getBytes(), new MessageProperties());

        doThrow(new RuntimeException("RabbitMQ connection error"))
            .when(rabbitTemplate).send(anyString(), anyString(), any(Message.class));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            try {
                rabbitMQProducerService.publishMessageToRabbitMQ(exchange, routingKey, message);
            } catch (RuntimeException e) {
                // Expected exception
            }

            // Then
            verify(rabbitTemplate, times(1)).send(eq(exchange), eq(""), eq(message));
            // No log verification since the method would throw an exception before logging
        }
    }
}