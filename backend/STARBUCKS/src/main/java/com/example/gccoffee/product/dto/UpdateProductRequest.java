package com.example.gccoffee.product.dto;

import com.example.gccoffee.product.vo.Category;
import com.example.gccoffee.product.vo.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateProductRequest(UUID productId, String productName, Category category, long price,
                                   String description, String imgUrl) {

    public Product toEntity() {
        return new Product(productId, productName, category, price, description, imgUrl, LocalDateTime.now(), LocalDateTime.now());
    }
}