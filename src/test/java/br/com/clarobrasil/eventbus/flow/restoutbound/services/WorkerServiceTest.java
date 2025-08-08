package br.com.clarobrasil.eventbus.flow.restoutbound.services;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.utils.WorkerUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.test.util.ReflectionTestUtils;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

import static br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants.ERROR_WORKER_RETRY;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkerServiceTest {

    @Mock
    private ReactiveSenderService reactiveSenderService;

    @Mock
    private RabbitMQProducerService rabbitMQService;

    @Mock
    private WorkerUtils workerUtils;

    @InjectMocks
    private WorkerService workerService;

    private static final String TEST_MESSAGE_BODY = "{\"key\":\"value\"}";
    private static final String TEST_MESSAGE_ID = "test-message-id";
    private static final String TEST_ERROR_EXCHANGE = "test-error-exchange";
    private static final String TEST_RESPONSE = "Success response";
    private static final Integer TEST_MAX_RETRY_ATTEMPTS = 3;
    private static final Integer TEST_RETRY_INTERVAL = 100;
    private static final Message TEST_ERROR_MESSAGE = new Message("error".getBytes(), new MessageProperties());

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(workerService, "maxRetryAttempts", TEST_MAX_RETRY_ATTEMPTS);
        ReflectionTestUtils.setField(workerService, "retryInterval", TEST_RETRY_INTERVAL);
        ReflectionTestUtils.setField(workerService, "retry", true);
        ReflectionTestUtils.setField(workerService, "errorExchange", TEST_ERROR_EXCHANGE);
    }

    @Test
    void testProcessMessage_FirstAttempt_Success() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(reactiveSenderService.sendRequest(any(HttpHeaders.class), anyString()))
            .thenReturn(Mono.just(TEST_RESPONSE));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(reactiveSenderService).sendRequest(any(HttpHeaders.class), eq(TEST_MESSAGE_BODY));
        }
    }

    @Test
    void testProcessMessage_RetryAttempt_Success() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        properties.setHeader("x-delivery-count", 2L);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(reactiveSenderService.sendRequest(any(HttpHeaders.class), anyString()))
            .thenReturn(Mono.just(TEST_RESPONSE));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(reactiveSenderService).sendRequest(any(HttpHeaders.class), eq(TEST_MESSAGE_BODY));
        }
    }

    @Test
    void testProcessMessage_MaxRetryAttemptsReached() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        properties.setHeader("x-delivery-count", (long) TEST_MAX_RETRY_ATTEMPTS + 1);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(workerUtils.receivedMessageToErrorMessage(any(Message.class), eq(ERROR_WORKER_RETRY)))
            .thenReturn(TEST_ERROR_MESSAGE);

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(rabbitMQService).publishMessageToRabbitMQ(eq(TEST_ERROR_EXCHANGE), eq(""), eq(TEST_ERROR_MESSAGE));
            verify(reactiveSenderService, never()).sendRequest(any(HttpHeaders.class), anyString());
        }
    }

    @Test
    void testProcessMessage_ExceptionDuringRequest_WithinRetryAttempts() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        properties.setHeader("x-delivery-count", 2L);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(reactiveSenderService.sendRequest(any(HttpHeaders.class), anyString()))
            .thenReturn(Mono.error(new RuntimeException("Test exception")));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertFalse(result);
        }
    }

    @Test
    void testProcessMessage_ExceptionDuringRequest_MaxRetryAttemptsReached() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        properties.setHeader("x-delivery-count", (long) TEST_MAX_RETRY_ATTEMPTS);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(reactiveSenderService.sendRequest(any(HttpHeaders.class), anyString()))
            .thenReturn(Mono.error(new RuntimeException("Test exception")));

        when(workerUtils.receivedMessageToErrorMessage(any(Message.class), eq("Test exception")))
            .thenReturn(TEST_ERROR_MESSAGE);

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(rabbitMQService).publishMessageToRabbitMQ(eq(TEST_ERROR_EXCHANGE), eq(""), eq(TEST_ERROR_MESSAGE));
        }
    }

    @Test
    void testProcessMessage_RetryDisabled() {
        // Given
        ReflectionTestUtils.setField(workerService, "retry", false);

        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        properties.setHeader("x-delivery-count", 2L);
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(workerUtils.receivedMessageToErrorMessage(any(Message.class), eq(ERROR_WORKER_RETRY)))
            .thenReturn(TEST_ERROR_MESSAGE);

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(rabbitMQService).publishMessageToRabbitMQ(eq(TEST_ERROR_EXCHANGE), eq(""), eq(TEST_ERROR_MESSAGE));
            verify(reactiveSenderService, never()).sendRequest(any(HttpHeaders.class), anyString());
        }
    }

    @Test
    void testProcessMessage_NullDeliveryCount() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setHeader("message-id", TEST_MESSAGE_ID);
        // No x-delivery-count header
        Message message = new Message(TEST_MESSAGE_BODY.getBytes(StandardCharsets.UTF_8), properties);

        when(reactiveSenderService.sendRequest(any(HttpHeaders.class), anyString()))
            .thenReturn(Mono.just(TEST_RESPONSE));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            boolean result = workerService.processMessage(message);

            // Then
            assertTrue(result);
            verify(reactiveSenderService).sendRequest(any(HttpHeaders.class), eq(TEST_MESSAGE_BODY));
        }
    }
}