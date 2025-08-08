package br.com.clarobrasil.eventbus.flow.restoutbound.services;

import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

public interface ReactiveSenderService {

    Mono<String> sendRequest(HttpHeaders headers, String body);
}
