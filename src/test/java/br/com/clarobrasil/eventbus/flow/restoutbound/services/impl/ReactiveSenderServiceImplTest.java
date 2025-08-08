package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.ApiGeeTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReactiveSenderServiceImplTest {

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;

    @Mock
    private WebClient.RequestBodySpec requestBodySpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @Mock
    private ApiGeeTokenService apiGeeTokenService;

    @InjectMocks
    private ReactiveSenderServiceImpl reactiveSenderService;

    private static final String TEST_TOKEN = "test-token";
    private static final String TEST_BODY = "{\"key\":\"value\"}";
    private static final String TEST_RESPONSE = "{\"response\":\"success\"}";

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(reactiveSenderService, "appRequestMethod", "POST");
        ReflectionTestUtils.setField(reactiveSenderService, "appRequestSchema", "https");
        ReflectionTestUtils.setField(reactiveSenderService, "appRequestBaseUrl", "api.example.com");
        ReflectionTestUtils.setField(reactiveSenderService, "appRequestPath", "/api/v1/resource");
        ReflectionTestUtils.setField(reactiveSenderService, "apigeeAuthType", "Bearer");

        Set<Integer> allowedStatusForRetry = new HashSet<>();
        allowedStatusForRetry.add(429);
        allowedStatusForRetry.add(503);
        ReflectionTestUtils.setField(reactiveSenderService, "allowedStatusForRetry", allowedStatusForRetry);

        when(webClientBuilder.build()).thenReturn(webClient);
    }

    @Test
    void testSendRequest_Success() {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        when(apiGeeTokenService.manageTokenAPIGEE()).thenReturn(TEST_TOKEN);
        when(webClient.method(any(HttpMethod.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(Function.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.header(anyString(), anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(TEST_RESPONSE));

        try (MockedStatic<LogUtil> logUtilMock = mockStatic(LogUtil.class)) {
            // When
            Mono<String> result = reactiveSenderService.sendRequest(headers, TEST_BODY);
            String response = result.block(); // Block to get the result

            // Then
            assertEquals(TEST_RESPONSE, response);

            verify(webClient).method(HttpMethod.POST);
            verify(requestBodySpec).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            verify(requestBodySpec).header(HttpHeaders.CONTENT_TYPE, headers.getFirst(HttpHeaders.CONTENT_TYPE));
            verify(requestBodySpec).header(HttpHeaders.AUTHORIZATION, "Bearer " + TEST_TOKEN);
            verify(requestBodySpec).bodyValue(TEST_BODY);
        }
    }

    @Test
    void testSendRequest_RetryableStatusCode() {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        when(apiGeeTokenService.manageTokenAPIGEE()).thenReturn(TEST_TOKEN);
        when(webClient.method(any(HttpMethod.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(Function.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.header(anyString(), anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

        // Mock the onStatus method to trigger the error for status code 429
        when(responseSpec.onStatus(any(), any())).thenAnswer(invocation -> {
            Function<ClientResponse, Mono<? extends Throwable>> errorHandler = invocation.getArgument(1);
            ClientResponse clientResponse = mock(ClientResponse.class);
            when(clientResponse.statusCode()).thenReturn(HttpStatus.TOO_MANY_REQUESTS); // 429
            errorHandler.apply(clientResponse);
            return responseSpec;
        });

        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.error(new RuntimeException("Error 429")));

        // When & Then
        Mono<String> result = reactiveSenderService.sendRequest(headers, TEST_BODY);

        Exception exception = assertThrows(RuntimeException.class, () -> result.block());
        assertEquals("Error 429", exception.getMessage());

        verify(webClient).method(HttpMethod.POST);
        verify(requestBodySpec).header(HttpHeaders.AUTHORIZATION, "Bearer " + TEST_TOKEN);
    }

    @Test
    void testSendRequest_NonRetryableStatusCode() {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        when(apiGeeTokenService.manageTokenAPIGEE()).thenReturn(TEST_TOKEN);
        when(webClient.method(any(HttpMethod.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(Function.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.header(anyString(), anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

        // Mock the onStatus method to not trigger for status code 400
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);

        String errorResponse = "{\"error\":\"Bad Request\"}";
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(errorResponse));

        // When
        Mono<String> result = reactiveSenderService.sendRequest(headers, TEST_BODY);
        String response = result.block(); // Block to get the result

        // Then
        assertEquals(errorResponse, response);

        verify(webClient).method(HttpMethod.POST);
        verify(requestBodySpec).header(HttpHeaders.AUTHORIZATION, "Bearer " + TEST_TOKEN);
    }

    @Test
    void testSendRequest_DifferentHttpMethod() {
        // Given
        ReflectionTestUtils.setField(reactiveSenderService, "appRequestMethod", "GET");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        when(apiGeeTokenService.manageTokenAPIGEE()).thenReturn(TEST_TOKEN);
        when(webClient.method(any(HttpMethod.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(Function.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.header(anyString(), anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(TEST_RESPONSE));

        // When
        Mono<String> result = reactiveSenderService.sendRequest(headers, TEST_BODY);
        String response = result.block(); // Block to get the result

        // Then
        assertEquals(TEST_RESPONSE, response);

        verify(webClient).method(HttpMethod.GET);
    }

    @Test
    void testSendRequest_WebClientError() {
        // Given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        when(apiGeeTokenService.manageTokenAPIGEE()).thenReturn(TEST_TOKEN);
        when(webClient.method(any(HttpMethod.class))).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri(any(Function.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.header(anyString(), anyString())).thenReturn(requestBodySpec);
        when(requestBodySpec.headers(any())).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);

        // Make sure onStatus returns responseSpec (not null)
        when(responseSpec.onStatus(any(), any())).thenReturn(responseSpec);

        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.error(new RuntimeException("WebClient error")));

        // When & Then
        Mono<String> result = reactiveSenderService.sendRequest(headers, TEST_BODY);

        Exception exception = assertThrows(RuntimeException.class, () -> result.block());
        assertEquals("WebClient error", exception.getMessage());

        verify(webClient).method(HttpMethod.POST);
        verify(requestBodySpec).header(HttpHeaders.AUTHORIZATION, "Bearer " + TEST_TOKEN);
    }
    }