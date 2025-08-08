package br.com.clarobrasil.eventbus.flow.restoutbound.services.impl;

import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobr.common.exception.BadRequestException;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.ApiGeeTokenService;
import br.com.clarobrasil.eventbus.flow.restoutbound.services.ReactiveSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Set;

import static br.com.clarobrasil.eventbus.flow.restoutbound.model.constants.CustomizedResponseConstants.*;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class ReactiveSenderServiceImpl implements ReactiveSenderService {

    @Value("${app.request.method}")
    private String appRequestMethod;

    @Value("${app.request.schema}")
    private String appRequestSchema;

    @Value("${app.request.base-url}")
    private String appRequestBaseUrl;

    @Value("${app.request.path}")
    private String appRequestPath;

    @Value("${apigee.auth.type}")
    private String apigeeAuthType;

    @Value("${app.request.alowed-status-for-retry}")
    private Set<Integer> allowedStatusForRetry;

    @Value("${app.request.enviar-headers-body}")
    private boolean enviarHeadersEBody;

    private final WebClient.Builder webClientBuilder;

    private final ApiGeeTokenService apiGeeTokenService;

    public Mono<String> sendRequest(HttpHeaders headers, String body) {

        var token = apiGeeTokenService.manageTokenAPIGEE();

        if (token == null) {
            LogUtil.info(log, "WorkerService.sendRequest: no token");
            throw new BadRequestException(ERROR_APIGEE.concat("getLastSubscriber: no token"), ERROR_API_CODE.concat(ERROR_API_CODE_INTERNAL));
        }

        WebClient webClient = webClientBuilder.build();

        if (enviarHeadersEBody) {
            return webClient.method(HttpMethod.valueOf(appRequestMethod.toUpperCase()))
                    .uri(uriBuilder -> uriBuilder
                            .scheme(appRequestSchema)
                            .host(appRequestBaseUrl)
                            .path(appRequestPath)
                            .queryParam("market", "XX_XX")
                            .build())
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                    .header(HttpHeaders.CONTENT_TYPE, headers.getFirst(HttpHeaders.CONTENT_TYPE))
                    .header(HttpHeaders.AUTHORIZATION, apigeeAuthType.concat(" ").concat(token))
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .bodyValue(body)
                    .retrieve()
                    .onStatus(status -> allowedStatusForRetry.contains(status.value()),
                            clientResponse -> Mono.error(new RuntimeException("Error " + clientResponse.statusCode().value())))
                    .bodyToMono(String.class)
                    .doOnSuccess(response -> LogUtil.info(log, "ReactiveSenderServiceImpl.sendRequest: returned status 200"));

        } else {
            return webClient.method(HttpMethod.valueOf(appRequestMethod.toUpperCase()))
                    .uri(uriBuilder -> uriBuilder
                            .scheme(appRequestSchema)
                            .host(appRequestBaseUrl)
                            .path(appRequestPath)
                            .queryParam("market", "XX_XX")
                            .build())
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                    .header(HttpHeaders.CONTENT_TYPE, headers.getFirst(HttpHeaders.CONTENT_TYPE))
                    .header(HttpHeaders.AUTHORIZATION, apigeeAuthType.concat(" ").concat(token))
//                .headers(httpHeaders -> httpHeaders.addAll(headers))
//                .bodyValue(body)
                    .retrieve()
                    .onStatus(status -> allowedStatusForRetry.contains(status.value()),
                            clientResponse -> Mono.error(new RuntimeException("Error " + clientResponse.statusCode().value())))
                    .bodyToMono(String.class)
                    .doOnSuccess(response -> LogUtil.info(log, "ReactiveSenderServiceImpl.sendRequest: returned status 200"));
        }
    }

}
