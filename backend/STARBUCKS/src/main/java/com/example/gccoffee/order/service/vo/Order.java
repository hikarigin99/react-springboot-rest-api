package com.example.gccoffee.order.service.vo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private String phoneNumber;
    private OrderStatus orderStatus;
    private final ReceiveType receiveType;
    private final List<OrderItem> orderItems;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(UUID orderId, String phoneNumber, OrderStatus orderStatus, ReceiveType receiveType, List<OrderItem> orderItems, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.orderStatus = orderStatus;
        this.receiveType = receiveType;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ReceiveType getReceiveType() {
        return receiveType;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.updatedAt = LocalDateTime.now();
    }

    public void changeOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderStatus=" + orderStatus +
                ", receiveType=" + receiveType +
                ", orderItems=" + orderItems +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
