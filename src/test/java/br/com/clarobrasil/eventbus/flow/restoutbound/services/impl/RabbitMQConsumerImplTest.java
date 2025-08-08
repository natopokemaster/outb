package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobrasil.eventbus.flow.restoutbound.services.WorkerService;
import com.rabbitmq.client.Channel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RabbitMQConsumerImplTest {

    @Mock
    private WorkerService workerService;

    @Mock
    private Channel channel;

    @InjectMocks
    private RabbitMQConsumerImpl rabbitMQConsumer;

    private Message message;
    private final long DELIVERY_TAG = 1L;

    @BeforeEach
    void setUp() {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("queue", "testQueue");
        message = new Message("testMessage".getBytes(), messageProperties);
    }

    @Test
    void testConsume_MessageAcknowledged() throws Exception {
        when(workerService.processMessage(message)).thenReturn(true);

        rabbitMQConsumer.consume(message, channel, DELIVERY_TAG);

        verify(channel, times(1)).basicAck(DELIVERY_TAG, false);
    }

    @Test
    void testConsume_MessageNotAcknowledged() throws Exception {
        when(workerService.processMessage(message)).thenReturn(false);

        rabbitMQConsumer.consume(message, channel, DELIVERY_TAG);

        verify(channel, times(1)).basicNack(DELIVERY_TAG, false, true);
    }

    @Test
    void testConsume_ErrorProcessingMessage() throws Exception {
        doThrow(new RuntimeException("Processing error")).when(workerService).processMessage(message);

        rabbitMQConsumer.consume(message, channel, DELIVERY_TAG);

        verify(channel, times(1)).basicNack(DELIVERY_TAG, false, true);
    }

    @Test
    void testConsume_ErrorNackingMessage() throws Exception {
        doThrow(new RuntimeException("Processing error")).when(workerService).processMessage(message);
        doThrow(new RuntimeException("NACK error")).when(channel).basicNack(DELIVERY_TAG, false, true);

        rabbitMQConsumer.consume(message, channel, DELIVERY_TAG);

        verify(channel, times(1)).basicNack(DELIVERY_TAG, false, true);
    }
}