package com.example.gccoffee.global.exception;

public class PriceOutOfRangeException extends RuntimeException {

    public PriceOutOfRangeException(String message) {
        super(message);
    }
}
