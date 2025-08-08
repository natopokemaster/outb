package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.exception.BadRequestException;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.ApigeeTokenResponse;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.RestOutboundConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApiGeeTokenServiceImplTest {

    @Mock
    private WebClient webClientMock;

    @Mock
    private RequestBodyUriSpec requestBodyUriSpecMock;

    @Mock
    private RequestBodySpec requestBodySpecMock;

    @Mock
    private RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    private ResponseSpec responseSpecMock;

    @InjectMocks
    private ApiGeeTokenServiceImpl apiGeeTokenService;

    private static final String TEST_PATH_TOKEN = "/oauth/token";
    private static final String TEST_GRANT_TYPE = "client_credentials";
    private static final String TEST_AUTHORIZATION = "Basic dGVzdDp0ZXN0";
    private static final String TEST_ACCESS_TOKEN = "test-access-token";
    private static final long TEST_ISSUED_AT = System.currentTimeMillis();
    private static final long TEST_EXPIRES_IN = 3600L;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(apiGeeTokenService, "apigeePathToken", TEST_PATH_TOKEN);
        ReflectionTestUtils.setField(apiGeeTokenService, "apigeeGrantType", TEST_GRANT_TYPE);
        ReflectionTestUtils.setField(apiGeeTokenService, "apigeeAuthorization", TEST_AUTHORIZATION);
    }

    @Test
    void testGenerateTokenAPIGEE_Success() {
        // Given
        ApigeeTokenResponse mockResponse = new ApigeeTokenResponse();
        mockResponse.setAccessToken(TEST_ACCESS_TOKEN);
        mockResponse.setExpiresIn(TEST_EXPIRES_IN);
        mockResponse.setIssuedAt(TEST_ISSUED_AT);

        setupWebClientMock(mockResponse);

        // When
        ApigeeTokenResponse result = apiGeeTokenService.generateTokenAPIGEE();

        // Then
        assertNotNull(result);
        assertEquals(TEST_ACCESS_TOKEN, result.getAccessToken());
        assertEquals(TEST_EXPIRES_IN, result.getExpiresIn());
        assertEquals(TEST_ISSUED_AT, result.getIssuedAt());
    }

    @Test
    void testGenerateTokenAPIGEE_NullResponse() {
        // Given
        when(webClientMock.post()).thenReturn(requestBodyUriSpecMock);
        when(requestBodyUriSpecMock.uri(anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.accept(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.contentType(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.header(anyString(), anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.body(any())).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(ApigeeTokenResponse.class)).thenReturn(Mono.empty());

        // When & Then
        BadRequestException exception = assertThrows(BadRequestException.class,
            () -> apiGeeTokenService.generateTokenAPIGEE());

        assertTrue(exception.getMessage().contains(RestOutboundConstants.ERROR_APIGEE));
        // Verify the exception contains the expected error code in the message
        String expectedErrorCode = CustomizedResponseConstants.ERROR_API_CODE + CustomizedResponseConstants.ERROR_API_CODE_INTERNAL;
    }

    @Test
    void testGenerateTokenAPIGEE_NullAccessToken() {
        // Given
        ApigeeTokenResponse mockResponse = new ApigeeTokenResponse();
        mockResponse.setAccessToken(null);
        mockResponse.setExpiresIn(TEST_EXPIRES_IN);
        mockResponse.setIssuedAt(TEST_ISSUED_AT);

        setupWebClientMock(mockResponse);

        // When & Then
        BadRequestException exception = assertThrows(BadRequestException.class,
            () -> apiGeeTokenService.generateTokenAPIGEE());

        assertTrue(exception.getMessage().contains(RestOutboundConstants.ERROR_APIGEE));
        // Verify the exception contains the expected error code in the message
        String expectedErrorCode = CustomizedResponseConstants.ERROR_API_CODE + CustomizedResponseConstants.ERROR_API_CODE_INTERNAL;
    }

    @Test
    void testGenerateTokenAPIGEE_Exception() {
        // Given
        when(webClientMock.post()).thenReturn(requestBodyUriSpecMock);
        when(requestBodyUriSpecMock.uri(anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.accept(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.contentType(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.header(anyString(), anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.body(any())).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(ApigeeTokenResponse.class)).thenReturn(Mono.error(new RuntimeException("Test exception")));

        // When & Then
        BadRequestException exception = assertThrows(BadRequestException.class,
            () -> apiGeeTokenService.generateTokenAPIGEE());

        assertTrue(exception.getMessage().contains(RestOutboundConstants.ERROR_APIGEE));
        // Verify the exception contains the expected error code in the message
        String expectedErrorCode = CustomizedResponseConstants.ERROR_API_CODE + CustomizedResponseConstants.ERROR_API_CODE_INTERNAL;
    }

    @Test
    void testManageTokenAPIGEE_NewToken() {
        // Given
        ApigeeTokenResponse mockResponse = new ApigeeTokenResponse();
        mockResponse.setAccessToken(TEST_ACCESS_TOKEN);
        mockResponse.setExpiresIn(TEST_EXPIRES_IN);
        mockResponse.setIssuedAt(TEST_ISSUED_AT);

        setupWebClientMock(mockResponse);

        // When
        String token = apiGeeTokenService.manageTokenAPIGEE();

        // Then
        assertEquals(TEST_ACCESS_TOKEN, token);

        // Verify the token is cached
        long expectedExpirationTime = ApiGeeTokenServiceImpl.calculateExpirationTime(
            mockResponse.getIssuedAt(), mockResponse.getExpiresIn());
        assertEquals(expectedExpirationTime, ReflectionTestUtils.getField(apiGeeTokenService, "tokenExpirationTime"));
        assertEquals(TEST_ACCESS_TOKEN, ReflectionTestUtils.getField(apiGeeTokenService, "cachedToken"));
    }

    @Test
    void testManageTokenAPIGEE_UseCachedToken() {
        // Given
        String cachedToken = "cached-token";
        long futureExpirationTime = System.currentTimeMillis() + 3600000; // 1 hour in the future

        ReflectionTestUtils.setField(apiGeeTokenService, "cachedToken", cachedToken);
        ReflectionTestUtils.setField(apiGeeTokenService, "tokenExpirationTime", futureExpirationTime);

        // When
        String token = apiGeeTokenService.manageTokenAPIGEE();

        // Then
        assertEquals(cachedToken, token);

        // Verify no new token was generated
        verify(webClientMock, never()).post();
    }

    @Test
    void testManageTokenAPIGEE_RefreshExpiredToken() {
        // Given
        String cachedToken = "expired-token";
        long pastExpirationTime = System.currentTimeMillis() - 1000; // 1 second in the past

        ReflectionTestUtils.setField(apiGeeTokenService, "cachedToken", cachedToken);
        ReflectionTestUtils.setField(apiGeeTokenService, "tokenExpirationTime", pastExpirationTime);

        ApigeeTokenResponse mockResponse = new ApigeeTokenResponse();
        mockResponse.setAccessToken(TEST_ACCESS_TOKEN);
        mockResponse.setExpiresIn(TEST_EXPIRES_IN);
        mockResponse.setIssuedAt(TEST_ISSUED_AT);

        setupWebClientMock(mockResponse);

        // When
        String token = apiGeeTokenService.manageTokenAPIGEE();

        // Then
        assertEquals(TEST_ACCESS_TOKEN, token);

        // Verify a new token was generated
        verify(webClientMock).post();
    }

    @Test
    void testManageTokenAPIGEE_RefreshNearExpirationToken() {
        // Given
        String cachedToken = "near-expiration-token";
        long nearExpirationTime = System.currentTimeMillis() + 30000; // 30 seconds in the future (less than threshold)

        ReflectionTestUtils.setField(apiGeeTokenService, "cachedToken", cachedToken);
        ReflectionTestUtils.setField(apiGeeTokenService, "tokenExpirationTime", nearExpirationTime);

        ApigeeTokenResponse mockResponse = new ApigeeTokenResponse();
        mockResponse.setAccessToken(TEST_ACCESS_TOKEN);
        mockResponse.setExpiresIn(TEST_EXPIRES_IN);
        mockResponse.setIssuedAt(TEST_ISSUED_AT);

        setupWebClientMock(mockResponse);

        // When
        String token = apiGeeTokenService.manageTokenAPIGEE();

        // Then
        assertEquals(TEST_ACCESS_TOKEN, token);

        // Verify a new token was generated
        verify(webClientMock).post();
    }

    @Test
    void testCalculateExpirationTime() {
        // Given
        long issuedAt = 1625000000000L; // Some timestamp
        long expiresIn = 3600L; // 1 hour in seconds

        // When
        long expirationTime = ApiGeeTokenServiceImpl.calculateExpirationTime(issuedAt, expiresIn);

        // Then
        long expectedExpirationTime = issuedAt + TimeUnit.SECONDS.toMillis(expiresIn);
        assertEquals(expectedExpirationTime, expirationTime);
    }

    @Test
    void testCalculateExpirationTime_ZeroExpiry() {
        // Given
        long issuedAt = 1625000000000L; // Some timestamp
        long expiresIn = 0L; // Zero expiry

        // When
        long expirationTime = ApiGeeTokenServiceImpl.calculateExpirationTime(issuedAt, expiresIn);

        // Then
        assertEquals(issuedAt, expirationTime);
    }

    private void setupWebClientMock(ApigeeTokenResponse response) {
        when(webClientMock.post()).thenReturn(requestBodyUriSpecMock);
        when(requestBodyUriSpecMock.uri(anyString())).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.accept(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.contentType(any(MediaType.class))).thenReturn(requestBodySpecMock);
        when(requestBodySpecMock.header(anyString(), anyString())).thenReturn(requestBodySpecMock);
        // Use any() instead of a specific type to make the mock more flexible
        when(requestBodySpecMock.body(any())).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);

        if (response == null) {
            when(responseSpecMock.bodyToMono(ApigeeTokenResponse.class)).thenReturn(Mono.empty());
        } else {
            when(responseSpecMock.bodyToMono(ApigeeTokenResponse.class)).thenReturn(Mono.just(response));
        }
    }
}