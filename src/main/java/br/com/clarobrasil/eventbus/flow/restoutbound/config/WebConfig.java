package br.com.clarobrasil.eventbus.flow.restoutbound.config;

import br.com.clarobr.common.base.correlation.RequestCorrelation;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Tonny Reis
 * @version 1.0.0
 */

@Configuration
public class WebConfig {

    @Value("${apigee.base-url}")
    private String apigeeBaseUrl;

    @Value("${apigee.connect-timeout-millis}")
    private Integer connectTimeoutMillis;

    @Value("${apigee.read-timeout-handler-seconds}")
    private Integer readTimeoutHandlerSeconds;

    @Value("${apigee.write-timeout-handler-seconds}")
    private Integer writeTimeoutHandlerSeconds;

    @Value("${apigee.max-connections}")
    private Integer maxConnections;

    @Value("${apigee.max-idle-time}")
    private Integer maxIdleTime;

    @Value("${apigee.max-life-time}")
    private Integer maxLifeTime;

    @Value("${apigee.pending-acquire-timeout}")
    private Integer pendingAcquireTimeout;

    @Value("${apigee.evict-in-background-time}")
    private Integer evictInBackground;

    @Value("${apigee.max-memory-size}")
    private Integer maxMemorySize;

    @Bean(value = "apigee")
    public WebClient webClient() {

        ConnectionProvider provider = ConnectionProvider.builder("apigee")
                .maxConnections(maxConnections)
                .maxIdleTime(Duration.ofSeconds(maxIdleTime))
                .maxLifeTime(Duration.ofSeconds(maxLifeTime))
                .pendingAcquireTimeout(Duration.ofSeconds(pendingAcquireTimeout))
                .evictInBackground(Duration.ofSeconds(evictInBackground)).build();

        var httpClient = HttpClient.create(provider)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeoutMillis)
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(readTimeoutHandlerSeconds, TimeUnit.SECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(writeTimeoutHandlerSeconds, TimeUnit.SECONDS)));

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer
                .defaultCodecs()
                .maxInMemorySize(maxMemorySize))
                .baseUrl(apigeeBaseUrl)
                .filter(addHeaderFilter())
                .build();
    }

    private ExchangeFilterFunction addHeaderFilter() {
        return (ClientRequest request, ExchangeFunction next) -> {
            ClientRequest newRequest = ClientRequest.from(request)
                    .header("X-Correlation-Id", RequestCorrelation.getCorrelationid())
                    .build();
            return next.exchange(newRequest);
        };
    }

}
