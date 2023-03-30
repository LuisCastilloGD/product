package com.grid.product.config;

import com.grid.product.exceptions.ProductNotAvailableException;
import com.grid.product.exceptions.ProductNotFoundedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.HttpClientErrorException;

public class CBConfig {
    /*
    Tried to ignore exception as it should be considered a failure but seems to not be supported.
    https://github.com/resilience4j/resilience4j/issues/1586
     */
    @Bean
    CircuitBreaker reportingApiCircuitBreaker(CircuitBreakerRegistry registry) {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                                                          .ignoreException(throwable -> {return throwable instanceof ProductNotAvailableException;})
                                                          .build();

        return registry.circuitBreaker("productCB", config);
    }
}
