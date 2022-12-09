package com.example.gccoffee.order.service.vo;

import com.example.gccoffee.product.service.vo.Category;

import java.util.UUID;

public record OrderItem(UUID productId, Category category, long price, int quantity) {
}
