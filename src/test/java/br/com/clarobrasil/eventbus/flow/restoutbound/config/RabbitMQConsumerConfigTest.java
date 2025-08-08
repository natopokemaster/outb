package br.com.clarobrasil.eventbus.flow.restoutbound.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class RabbitMQConsumerConfigTest {

    @Mock
    private ConnectionFactory connectionFactory;

    @InjectMocks
    private RabbitMQConsumerConfig rabbitMQConsumerConfig;

    @Test
    void testSimpleRabbitListenerContainerFactory() {
        // Act
        SimpleRabbitListenerContainerFactory factory = rabbitMQConsumerConfig.simpleRabbitListenerContainerFactory(connectionFactory);

        // Assert
        assertNotNull(factory, "Factory should not be null");

        // Use reflection to access the acknowledgeMode field
        AcknowledgeMode acknowledgeMode = (AcknowledgeMode) ReflectionTestUtils.getField(factory, "acknowledgeMode");
        assertEquals(AcknowledgeMode.MANUAL, acknowledgeMode, "Acknowledge mode should be set to MANUAL");
    }

    @Test
    void testFactoryUsesProvidedConnectionFactory() {
        // Arrange
        ConnectionFactory customConnectionFactory = mock(ConnectionFactory.class);

        // Act
        SimpleRabbitListenerContainerFactory factory = rabbitMQConsumerConfig.simpleRabbitListenerContainerFactory(customConnectionFactory);

        // Assert
        assertNotNull(factory, "Factory should not be null");

        // Use reflection to verify the connection factory was set
        ConnectionFactory usedConnectionFactory = (ConnectionFactory) ReflectionTestUtils.getField(factory, "connectionFactory");
        assertSame(customConnectionFactory, usedConnectionFactory, "Factory should use the provided connection factory");
    }

    @Test
    void testFactoryWithNullConnectionFactory() {
        // Act
        SimpleRabbitListenerContainerFactory factory = rabbitMQConsumerConfig.simpleRabbitListenerContainerFactory(null);

        // Assert
        assertNotNull(factory, "Factory should not be null even with null connection factory");

        // Use reflection to verify the connection factory was set to null
        ConnectionFactory usedConnectionFactory = (ConnectionFactory) ReflectionTestUtils.getField(factory, "connectionFactory");
        assertNull(usedConnectionFactory, "Factory should have null connection factory");
    }

    @Test
    void testFactoryDefaultConfiguration() {
        // Act
        SimpleRabbitListenerContainerFactory factory = rabbitMQConsumerConfig.simpleRabbitListenerContainerFactory(connectionFactory);

        // Assert
        assertNotNull(factory, "Factory should not be null");

        // Use reflection to access the fields
        AcknowledgeMode acknowledgeMode = (AcknowledgeMode) ReflectionTestUtils.getField(factory, "acknowledgeMode");
        assertEquals(AcknowledgeMode.MANUAL, acknowledgeMode, "Acknowledge mode should be set to MANUAL");

        // Verify the connection factory was set
        ConnectionFactory usedConnectionFactory = (ConnectionFactory) ReflectionTestUtils.getField(factory, "connectionFactory");
        assertSame(connectionFactory, usedConnectionFactory, "Factory should use the provided connection factory");
    }
}