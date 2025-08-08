package br.com.clarobrasil.eventbus.flow.restoutbound.utils;

import br.com.clarobr.common.base.utils.LogUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockedStatic;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkerUtilsTest {

    @InjectMocks
    private WorkerUtils workerUtils;

    @Spy
    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(workerUtils, "queueValue", "test-queue");
        ReflectionTestUtils.setField(workerUtils, "eventValue", "test-event");
        ReflectionTestUtils.setField(workerUtils, "appIdValue", "test-app-id");
        ReflectionTestUtils.setField(workerUtils, "levelValue", "test-level");
        ReflectionTestUtils.setField(workerUtils, "zoneId", "UTC");
    }

    @Test
    void testReceivedMessageToErrorMessage_Success() {
        // Given
        MessageProperties properties = new MessageProperties();
        properties.setContentType("application/json");
        properties.setHeader("test-header", "test-value");
        Message receivedMessage = new Message("{\"test\":\"data\"}".getBytes(), properties);
        String errorMessage = "Test error message";

        try (MockedStatic<WorkerUtils> workerUtilsMock = mockStatic(WorkerUtils.class, invocation -> {
            if (invocation.getMethod().getName().equals("getHostName")) {
                return "test-host";
            }
            return invocation.callRealMethod();
        })) {
            // When
            Message result = workerUtils.receivedMessageToErrorMessage(receivedMessage, errorMessage);

            // Then
            assertNotNull(result);
            assertEquals("application/json", result.getMessageProperties().getContentType());
            assertEquals("test-queue", result.getMessageProperties().getHeaders().get("queue"));
            assertEquals("test-event", result.getMessageProperties().getHeaders().get("event"));
            assertEquals("test-app-id", result.getMessageProperties().getHeaders().get("app-id"));
            assertEquals("test-host", result.getMessageProperties().getHeaders().get("consumer-id"));
            assertNotNull(result.getMessageProperties().getHeaders().get("published"));
            assertEquals("test-level", result.getMessageProperties().getHeaders().get("level"));
        }
    }

    @Test
    void testReceivedMessageToErrorMessage_NullMessageToJson() throws Exception {
        // Given
        MessageProperties properties = new MessageProperties();
        Message receivedMessage = new Message("test".getBytes(), properties);
        String errorMessage = "Test error message";

        try (MockedStatic<WorkerUtils> workerUtilsMock = mockStatic(WorkerUtils.class, invocation -> {
            if (invocation.getMethod().getName().equals("getHostName")) {
                return "test-host";
            }
            return invocation.callRealMethod();
        })) {
            // Mock the messageToJson method to return null
            WorkerUtils spyWorkerUtils = spy(workerUtils);
            doReturn(null).when(spyWorkerUtils).messageToJson(any(Message.class), anyString());

            // When
            Message result = spyWorkerUtils.receivedMessageToErrorMessage(receivedMessage, errorMessage);

            // Then
            assertNull(result);
        }
    }

    @Test
    void testReceivedMessageToErrorMessage_Exception() throws Exception {
        // Given
        MessageProperties properties = new MessageProperties();
        Message receivedMessage = new Message("test".getBytes(), properties);
        String errorMessage = "Test error message";

        try (MockedStatic<WorkerUtils> workerUtilsMock = mockStatic(WorkerUtils.class, invocation -> {
            if (invocation.getMethod().getName().equals("getHostName")) {
                return "test-host";
            }
            return invocation.callRealMethod();
        }); MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // Mock the messageToJson method to throw an exception
            WorkerUtils spyWorkerUtils = spy(workerUtils);
            doThrow(new RuntimeException("Test exception")).when(spyWorkerUtils).messageToJson(any(Message.class), anyString());

            // When
            Message result = spyWorkerUtils.receivedMessageToErrorMessage(receivedMessage, errorMessage);

            // Then
            assertNull(result);
        }
    }

    @Test
    void testZonedDateTimeToTimestamp_WithoutNanoSeconds() {
        // Given
        ReflectionTestUtils.setField(workerUtils, "applyNanoTimeStamp", false);
        ZonedDateTime dateTime = ZonedDateTime.of(2023, 1, 1, 12, 0, 0, 123456789, ZoneId.of("UTC"));

        // When
        String result = workerUtils.zonedDateTimeToTimestamp(dateTime);

        // Then
        assertEquals("2023-01-01T12:00:00Z", result);
    }

    @Test
    void testZonedDateTimeToTimestamp_WithNanoSeconds() {
        // Given
        ReflectionTestUtils.setField(workerUtils, "applyNanoTimeStamp", true);
        ZonedDateTime dateTime = ZonedDateTime.of(2023, 1, 1, 12, 0, 0, 123456789, ZoneId.of("UTC"));

        // When
        String result = workerUtils.zonedDateTimeToTimestamp(dateTime);

        // Then
        assertEquals("2023-01-01T12:00:00.123456789Z", result);
    }

    @Test
    void testZonedDateTimeToTimestamp_DifferentTimeZone() {
        // Given
        ReflectionTestUtils.setField(workerUtils, "applyNanoTimeStamp", false);
        ReflectionTestUtils.setField(workerUtils, "zoneId", "America/New_York");
        ZonedDateTime dateTime = ZonedDateTime.of(2023, 1, 1, 12, 0, 0, 0, ZoneId.of("UTC"));

        // When
        String result = workerUtils.zonedDateTimeToTimestamp(dateTime);

        // Then
        // UTC noon is 7am in New York (UTC-5)
        assertEquals("2023-01-01T07:00:00-05:00", result);
    }

    @Test
    void testMessageToJson_Success() throws JsonProcessingException {
        // Given
        MessageProperties properties = new MessageProperties();
        Map<String, Object> headers = new HashMap<>();
        headers.put("header1", "value1");
        headers.put("header2", "value2");
        properties.setHeaders(headers);
        Message message = new Message("{\"test\":\"data\"}".getBytes(), properties);
        String errorMessage = "Test error message";

        // When
        String result = workerUtils.messageToJson(message, errorMessage);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("\"message\":\"Test error message\""));
        assertTrue(result.contains("\"headers\":{"));
        assertTrue(result.contains("\"header1\":\"value1\""));
        assertTrue(result.contains("\"header2\":\"value2\""));
        assertTrue(result.contains("\"payload\":\"{\\\"test\\\":\\\"data\\\"}\""));
    }

    @Test
    void testMessageToJson_NullMessage() throws JsonProcessingException {
        // Given
        Message message = null;
        String errorMessage = "Test error message";

        // When
        String result = workerUtils.messageToJson(message, errorMessage);

        // Then
        assertNull(result);
    }

    @Test
    void testMessageToJson_NullMessageProperties() throws JsonProcessingException {
        // Given
        Message message = mock(Message.class);
        when(message.getMessageProperties()).thenReturn(null);
        String errorMessage = "Test error message";

        // When
        String result = workerUtils.messageToJson(message, errorMessage);

        // Then
        assertNull(result);
    }

    @Test
    void testMessageToJson_NullHeaders() throws JsonProcessingException {
        // Given
        MessageProperties properties = mock(MessageProperties.class);
        when(properties.getHeaders()).thenReturn(null);

        Message message = mock(Message.class);
        when(message.getMessageProperties()).thenReturn(properties);
        // Use lenient() to allow this stubbing even if it's not used
        lenient().when(message.getBody()).thenReturn("test".getBytes());

        String errorMessage = "Test error message";

        // When
        String result = workerUtils.messageToJson(message, errorMessage);

        // Then
        assertNull(result);
    }

    @Test
    void testMessageToJson_NullBody() throws JsonProcessingException {
        // Given
        MessageProperties properties = new MessageProperties();
        Message message = mock(Message.class);
        when(message.getMessageProperties()).thenReturn(properties);
        when(message.getBody()).thenReturn(null);
        String errorMessage = "Test error message";

        // When
        String result = workerUtils.messageToJson(message, errorMessage);

        // Then
        assertNull(result);
    }

    @Test
    void testMessageToJson_JsonProcessingException() throws JsonProcessingException {
        // Given
        MessageProperties properties = new MessageProperties();
        Message message = new Message("{\"test\":\"data\"}".getBytes(), properties);
        String errorMessage = "Test error message";

        ObjectMapper mockObjectMapper = mock(ObjectMapper.class);
        when(mockObjectMapper.writeValueAsString(any())).thenThrow(new JsonProcessingException("Test exception") {});
        ReflectionTestUtils.setField(workerUtils, "objectMapper", mockObjectMapper);

        // When & Then
        assertThrows(JsonProcessingException.class, () -> workerUtils.messageToJson(message, errorMessage));
    }
}