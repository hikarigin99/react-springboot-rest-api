package com.example.gccoffee.order.service;

import com.example.gccoffee.order.vo.Order;
import com.example.gccoffee.order.vo.ReceiveType;
import com.example.gccoffee.order.vo.OrderItem;
import com.example.gccoffee.order.vo.OrderStatus;

import java.util.List;

public interface OrderService {

    Order createOrder(String phoneNumber, OrderStatus orderStatus, ReceiveType receiveType, List<OrderItem> orderItems);
}
