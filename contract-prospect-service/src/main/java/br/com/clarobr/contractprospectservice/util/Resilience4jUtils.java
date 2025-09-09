package br.com.clarobr.contractprospectservice.util;

/**
 * @author Alan Ricardo
 */

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;

public class Resilience4jUtils {

    private Resilience4jUtils () {

    }

    @SuppressWarnings("all")
    public static String logCircuitBreakerConfig (CircuitBreaker circuitBreaker) {

        var config = circuitBreaker.getCircuitBreakerConfig();

        @SuppressWarnings("deprecation")
        String configStr = String.format("[Circuit Breaker: %s%n######### CB: failure: %s%n######### CB: window size: %s%n######### CB: min number of calls: %s%n######### CB: permitted half open state: %s%n######### CB: wait duration in open state %s %n######### CB: interval function %s%n######### CB: automatic transition to half open: %s%n######### CB: slow call rate thresh: %s%n######### CB: slow call duration thresh: %s%n ]",
                circuitBreaker.getName(),
                config.getFailureRateThreshold(),
                config.getSlidingWindowSize(),
                config.getMinimumNumberOfCalls(),
                config.getPermittedNumberOfCallsInHalfOpenState(),
                config.getWaitDurationInOpenState(),
                config.getWaitIntervalFunctionInOpenState().toString(),
                config.isAutomaticTransitionFromOpenToHalfOpenEnabled(),
                config.getSlowCallRateThreshold(),
                config.getSlowCallDurationThreshold());

        return configStr;
    }

    @SuppressWarnings("all")
    public static String logRetryConfig (Retry retry) {

        var retryConfig = retry.getRetryConfig();

        String configStr = String.format("[Retry: %s%n######### RETRY: max attempts: %s%n######### RETRY: interval wait duration: %s%n]",
                retry.getName(),
                retryConfig.getMaxAttempts(),
                retryConfig.getIntervalBiFunction().toString());

        return configStr;

    }

    @SuppressWarnings("all")
    public static String logRateLimiterConfig (RateLimiter rateLimiter) {

        var rateLimiterConfig = rateLimiter.getRateLimiterConfig();

        String configStr = String.format("[RateLimiter: %s%n######### RateLim: limit for perdiod: %s%n######### RateLim: limit refresh period: %s%n######### RateLim: timeout duration: %s%n]",
                rateLimiter.getName(),
                rateLimiterConfig.getLimitForPeriod(),
                rateLimiterConfig.getLimitRefreshPeriod(),
                rateLimiterConfig.getTimeoutDuration());

        return configStr;

    }

    @SuppressWarnings("all")
    public static String logBulkheadConfig (Bulkhead bulkHead) {

        var bulkHeadConfig = bulkHead.getBulkheadConfig();

        String configStr = String.format("[Bulkhead: %s%n######### BH: max concurrent calls: %s%n######### BH: max wait duration: %s %n]",
                bulkHead.getName(),
                bulkHeadConfig.getMaxConcurrentCalls(),
                bulkHeadConfig.getMaxWaitDuration());

        return configStr;

    }



}

