package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobr.common.exception.BadRequestException;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.ApigeeTokenResponse;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants;
import br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.RestOutboundConstants;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.ApiGeeTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@Service
public class ApiGeeTokenServiceImpl implements ApiGeeTokenService {

    @Value("${apigee.path-token}")
    private String apigeePathToken;

    @Value("${apigee.grant-type}")
    private String apigeeGrantType;

    @Value("${apigee.authorization}")
    private String apigeeAuthorization;

    private final WebClient webClient;

    private String cachedToken;

    private long tokenExpirationTime;

    private static final long TOKEN_REFRESH_THRESHOLD = 60 * 1000L;

    public ApiGeeTokenServiceImpl(@Qualifier("apigee") WebClient webClient) {
        this.webClient = webClient;
    }

    public ApigeeTokenResponse generateTokenAPIGEE() {
        LogUtil.debug(log,"Start ApiGeeTokenServiceImpl.generateTokenAPIGEE");
        Mono<ApigeeTokenResponse> response = webClient.post()
                .uri(apigeePathToken)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .header(HttpHeaders.AUTHORIZATION, apigeeAuthorization)
                .body(BodyInserters.fromValue("grant_type=" + apigeeGrantType))
                .retrieve()
                .bodyToMono(ApigeeTokenResponse.class);
        try {
            var apigeeTokenResponse = response.block();
            if (apigeeTokenResponse != null && apigeeTokenResponse.getAccessToken() != null) {
                LogUtil.debug(log,"Finished ApiGeeTokenServiceImpl.generateTokenAPIGEE expirationTime: {}", apigeeTokenResponse.getExpiresIn());
                return apigeeTokenResponse;
            }
            LogUtil.error(log,"ApiGeeTokenServiceImpl.generateTokenAPIGEE error response not found");
            throw new BadRequestException(RestOutboundConstants.ERROR_APIGEE.concat("generateTokenAPIGEE null"), CustomizedResponseConstants.ERROR_API_CODE.concat(CustomizedResponseConstants.ERROR_API_CODE_INTERNAL));
        } catch (Exception ex) {
            LogUtil.error(log,"ApiGeeTokenServiceImpl.generateTokenAPIGEE error: {}", ex.getMessage() == null ? "Messsage exception is null " : ex.getMessage() + "Cause test -> " + ex.getCause());
            throw new BadRequestException(RestOutboundConstants.ERROR_APIGEE.concat(ex.getMessage()), CustomizedResponseConstants.ERROR_API_CODE.concat(CustomizedResponseConstants.ERROR_API_CODE_INTERNAL));
        }
    }

    public String manageTokenAPIGEE() {
        LogUtil.debug(log,"Start ApiGeeTokenServiceImpl.manageTokenAPIGEE");
        if (cachedToken != null && System.currentTimeMillis() < tokenExpirationTime - TOKEN_REFRESH_THRESHOLD) {
            LogUtil.debug(log,"Finished ApiGeeTokenServiceImpl.manageTokenAPIGEE cachedToken: {}", cachedToken);
            return cachedToken;
        }
        var apigeeTokenResponse = generateTokenAPIGEE();
        cachedToken = apigeeTokenResponse.getAccessToken();
        tokenExpirationTime = calculateExpirationTime(apigeeTokenResponse.getIssuedAt(), apigeeTokenResponse.getExpiresIn());
        LogUtil.debug(log,"Finished ApiGeeTokenServiceImpl.generateTokenAPIGEE token: {}, expirationTime: {}", cachedToken, tokenExpirationTime);
        return cachedToken;
    }

    public static long calculateExpirationTime(Long issuedAt, Long expiresIn) {
        var expiresInMillis = TimeUnit.SECONDS.toMillis(expiresIn);
        return issuedAt + expiresInMillis;
    }

}
