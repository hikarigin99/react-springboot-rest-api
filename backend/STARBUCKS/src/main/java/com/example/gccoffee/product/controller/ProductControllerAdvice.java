package com.example.gccoffee.product.controller;

import com.example.gccoffee.global.exception.PriceOutOfRangeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(PriceOutOfRangeException.class)
    public String handleProductPriceOutOfRange() {
        return "product-error";
    }
}
