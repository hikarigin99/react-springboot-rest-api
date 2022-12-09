package com.example.gccoffee.product.controller.exception;

public class PriceOutOfRangeException extends RuntimeException {

    public PriceOutOfRangeException(String message) {
        super(message);
    }
}
