package com.grid.product.exceptions;

public class ProductNotFoundedException extends RuntimeException{
    public ProductNotFoundedException() {
        super("Product not founded");
    }

}
