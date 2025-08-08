package br.com.clarobrasil.eventbus.flow.restoutbound.config;

import br.com.clarobr.common.base.correlation.RequestCorrelation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WebConfigTest {

    @InjectMocks
    private WebConfig webConfig;

    @Mock
    private ExchangeFunction exchangeFunction;

    private static final String CORRELATION_ID = "test-correlation-id";
    private static final String APIGEE_BASE_URL = "https://api.example.com";

    @BeforeEach
    void setUp() {
        // Set up the properties using reflection
        ReflectionTestUtils.setField(webConfig, "apigeeBaseUrl", APIGEE_BASE_URL);
        ReflectionTestUtils.setField(webConfig, "connectTimeoutMillis", 5000);
        ReflectionTestUtils.setField(webConfig, "readTimeoutHandlerSeconds", 30);
        ReflectionTestUtils.setField(webConfig, "writeTimeoutHandlerSeconds", 30);
        ReflectionTestUtils.setField(webConfig, "maxConnections", 500);
        ReflectionTestUtils.setField(webConfig, "maxIdleTime", 20);
        ReflectionTestUtils.setField(webConfig, "maxLifeTime", 60);
        ReflectionTestUtils.setField(webConfig, "pendingAcquireTimeout", 60);
        ReflectionTestUtils.setField(webConfig, "evictInBackground", 120);
        ReflectionTestUtils.setField(webConfig, "maxMemorySize", 16777216);
    }

    @Test
    void testWebClientCreation() {
        // When
        WebClient webClient = webConfig.webClient();

        // Then
        assertNotNull(webClient, "WebClient should not be null");
    }

    @Test
    void testWebClientBaseUrl() {
        // Given
        String expectedBaseUrl = APIGEE_BASE_URL;

        // When
        WebClient webClient = webConfig.webClient();

        // Then
        // We can't directly test the base URL of the WebClient as it's not exposed
        // But we can verify it was created successfully
        assertNotNull(webClient, "WebClient should be created with base URL: " + expectedBaseUrl);
    }

    @Test
    void testAddHeaderFilter() throws Exception {
        // Given
        ClientRequest request = ClientRequest.create(HttpMethod.GET, URI.create("https://test.com")).build();

        when(exchangeFunction.exchange(any(ClientRequest.class)))
                .thenReturn(Mono.empty());

        // Using MockedStatic to mock the static method
        try (MockedStatic<RequestCorrelation> mockedStatic = Mockito.mockStatic(RequestCorrelation.class)) {
            mockedStatic.when(RequestCorrelation::getCorrelationid).thenReturn(CORRELATION_ID);

            // When
            ExchangeFilterFunction filterFunction = (ExchangeFilterFunction) ReflectionTestUtils.invokeMethod(
                    webConfig, "addHeaderFilter");

            assertNotNull(filterFunction, "Filter function should not be null");

            // Execute the filter
            filterFunction.filter(request, exchangeFunction).subscribe();

            // Then
            verify(exchangeFunction).exchange(argThat(req -> {
                HttpHeaders headers = req.headers();
                return headers.getFirst("X-Correlation-Id").equals(CORRELATION_ID);
            }));
        }
    }

    @Test
    void testCustomConfigurationValues() {
        // Given
        int customConnectTimeout = 10000;
        int customMaxConnections = 1000;
        int customMaxMemorySize = 32 * 1024 * 1024;

        // Set custom values
        ReflectionTestUtils.setField(webConfig, "connectTimeoutMillis", customConnectTimeout);
        ReflectionTestUtils.setField(webConfig, "maxConnections", customMaxConnections);
        ReflectionTestUtils.setField(webConfig, "maxMemorySize", customMaxMemorySize);

        // When
        WebClient webClient = webConfig.webClient();

        // Then
        assertNotNull(webClient, "WebClient should be created with custom configuration values");
    }

    @Test
    void testNullCorrelationId() throws Exception {
        // Given
        ClientRequest request = ClientRequest.create(HttpMethod.GET, URI.create("https://test.com")).build();

        when(exchangeFunction.exchange(any(ClientRequest.class)))
                .thenReturn(Mono.empty());

        // Using MockedStatic to mock the static method
        try (MockedStatic<RequestCorrelation> mockedStatic = Mockito.mockStatic(RequestCorrelation.class)) {
            mockedStatic.when(RequestCorrelation::getCorrelationid).thenReturn(null);

            // When
            ExchangeFilterFunction filterFunction = (ExchangeFilterFunction) ReflectionTestUtils.invokeMethod(
                    webConfig, "addHeaderFilter");

            // Execute the filter
            filterFunction.filter(request, exchangeFunction).subscribe();

            // Then
            verify(exchangeFunction).exchange(argThat(req -> {
                HttpHeaders headers = req.headers();
                return headers.getFirst("X-Correlation-Id") == null;
            }));
        }
    }
}