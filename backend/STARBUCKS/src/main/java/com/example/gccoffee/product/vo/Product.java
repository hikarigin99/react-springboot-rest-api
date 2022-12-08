package com.example.gccoffee.product.vo;

import com.example.gccoffee.global.exception.PriceOutOfRangeException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Product {

    private final UUID productId;
    private String productName;
    private Category category;
    private long price;
    private String description;
    private String imgUrl;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(UUID productId, String productName, Category category, long price, String description, String imgUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        if (price < 0) {
            throw new PriceOutOfRangeException("가격은 음수가 될 수 없다");
        }
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        this.updatedAt = LocalDateTime.now();
    }

    public void setCategory(Category category) {
        this.category = category;
        this.updatedAt = LocalDateTime.now();
    }

    public void setPrice(long price) {
        this.price = price;
        this.updatedAt = LocalDateTime.now();
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        this.updatedAt = LocalDateTime.now();
    }

    public UUID getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Category getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}

