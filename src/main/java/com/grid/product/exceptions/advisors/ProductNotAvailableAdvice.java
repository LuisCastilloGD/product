package com.grid.product.exceptions.advisors;

import com.grid.product.exceptions.ProductNotAvailableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductNotAvailableAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ProductNotAvailableException.class)
    public String productNotAvailableHandler(final ProductNotAvailableException e) {
        return e.getMessage();
    }

}
