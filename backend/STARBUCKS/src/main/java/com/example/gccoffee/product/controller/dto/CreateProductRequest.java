package com.example.gccoffee.product.controller.dto;

import com.example.gccoffee.product.service.vo.Category;

public record CreateProductRequest(String productName, Category category, long price, String description,
                                   String imgUrl) {
}
