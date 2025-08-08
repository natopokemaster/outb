package br.com.clarobrasil.eventbus.flow.restoutbound.utils;

import br.com.clarobr.common.base.utils.LogUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.HashMap;
import java.util.Map;

import static br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants.ERROR_WORKER_MESSAGE_CONVERTER;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkerUtils {

    public static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

    @Value("${app.rabbitmq.queue}")
    private String queueValue;

    @Value("${app.rabbitmq.header.event}")
    private String eventValue;

    @Value("${app.rabbitmq.header.app-id}")
    private String appIdValue;

    @Value("${app.rabbitmq.header.level}")
    private String levelValue;

    @Value("${app.zone-id}")
    private String zoneId;

    @Value("${app.apply-nano-timestamp}")
    private boolean applyNanoTimeStamp;

    private final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.ALWAYS);

    private static final String QUEUE = "queue";
    private static final String EVENT = "event";
    private static final String APP_ID = "app-id";
    private static final String CONSUMER_ID = "consumer-id";
    private static final String PUBLISHED = "published";
    private static final String LEVEL = "level";

    public Message receivedMessageToErrorMessage(Message receivedMessage, String errorMessage) {

        try {
            String errorMessagebody = messageToJson(receivedMessage, errorMessage);
            if (errorMessagebody != null) {
                return MessageBuilder.withBody(errorMessagebody.getBytes())
                        .setContentType(receivedMessage.getMessageProperties().getContentType())
                        .setHeader(QUEUE, queueValue)
                        .setHeader(EVENT, eventValue)
                        .setHeader(APP_ID, appIdValue)
                        .setHeader(CONSUMER_ID, getHostName())
                        .setHeader(PUBLISHED, zonedDateTimeToTimestamp(ZonedDateTime.now()))
                        .setHeader(LEVEL, levelValue)
                        .build();
            } else {
                throw new IllegalStateException(ERROR_WORKER_MESSAGE_CONVERTER);
            }
        } catch (Exception e) {
            LogUtil.error(log, "WorkerUtils.receivedMessageToErrorMessage: Error to convert message: {}", e.getMessage());
        }
        return null;
    }

    public String zonedDateTimeToTimestamp(ZonedDateTime dateTime) {

        ZonedDateTime zonedDateTime = dateTime.withZoneSameInstant(ZoneId.of(zoneId));

        if (!applyNanoTimeStamp) {
            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern(YYYY_MM_DD_T_HH_MM_SS)
                    .appendPattern("XXX")
                    .toFormatter();

            return formatter.format(zonedDateTime);
        } else {

            DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                    .appendPattern(YYYY_MM_DD_T_HH_MM_SS)
                    .appendFraction(ChronoField.NANO_OF_SECOND, 9, 9, true)
                    .appendPattern("XXX")
                    .toFormatter();

            return formatter.format(zonedDateTime);
        }
    }

    public static String getHostName() {
        var hostName = System.getenv("HOSTNAME");
        if (hostName == null) {
            hostName = System.getenv("COMPUTERNAME");
        }

        return !hostName.isEmpty() ? hostName : "unknown";
    }

    public String messageToJson(Message message, String errorMessage) throws JsonProcessingException {

        if (message != null && message.getMessageProperties() != null && message.getMessageProperties().getHeaders() != null && message.getBody() != null) {

            var body = new String(message.getBody());
            Map<String, Object> headers = new HashMap<>(message.getMessageProperties().getHeaders());

            var jsonMessage = MessageRecord.builder()
                    .message(errorMessage)
                    .headers(headers)
                    .payload(body)
                    .build();

            return objectMapper.writeValueAsString(jsonMessage);
        }
        return null;
    }
}

@Builder
record MessageRecord(String message, Map<String, Object> headers, String payload) {
}