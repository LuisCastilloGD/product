package com.grid.product.exceptions;

public class ProductNotAvailableException extends RuntimeException{
    public ProductNotAvailableException() {
        super("Product with no availability");
    }

}
