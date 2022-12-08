package com.example.gccoffee.order.vo;

import com.example.gccoffee.product.vo.Category;

import java.util.UUID;

public record OrderItem(UUID productId, Category category, long price, int quantity) {
}
