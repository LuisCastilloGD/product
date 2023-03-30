package com.grid.product.config;


import com.grid.product.exceptions.ProductNotFoundedException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomFeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(final String s, final Response response) {

        switch (response.status()) {
            case 404 -> {
                log.error("Error in request went through feign client");
                return new ProductNotFoundedException();
            }
            case 401 -> {
                log.error("Unauthorized Request Through Feign");
                return new Exception("Unauthorized Request Through Feign");
            }
            default -> {
                log.error("Error in request went through feign client");
                return new RuntimeException("Common Feign Exception");
            }
        }
    }




}
