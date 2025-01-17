package com.example.gccoffee.order.controller.dto;

import com.example.gccoffee.order.service.vo.OrderItem;
import com.example.gccoffee.order.service.vo.OrderStatus;
import com.example.gccoffee.order.service.vo.ReceiveType;

import java.util.List;

public class CreateOrderRequest {

    private String phoneNumber;
    private OrderStatus orderStatus;
    private ReceiveType receiveType;
    private List<OrderItem> orderItems;

    public CreateOrderRequest() {
        this.orderStatus = OrderStatus.PAYMENT_CONFIRMED;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public ReceiveType getReceiveType() {
        return receiveType;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
