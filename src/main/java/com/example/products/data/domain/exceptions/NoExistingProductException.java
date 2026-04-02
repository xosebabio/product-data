package com.example.products.data.domain.exceptions;

public class NoExistingProductException extends RuntimeException {
    public NoExistingProductException(String message) {
        super(message);
    }
}
