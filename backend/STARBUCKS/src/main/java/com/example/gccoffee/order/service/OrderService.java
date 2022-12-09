package com.example.gccoffee.order.service;

import com.example.gccoffee.order.service.vo.Order;
import com.example.gccoffee.order.service.vo.ReceiveType;
import com.example.gccoffee.order.service.vo.OrderItem;
import com.example.gccoffee.order.service.vo.OrderStatus;

import java.util.List;

public interface OrderService {

    Order createOrder(String phoneNumber, OrderStatus orderStatus, ReceiveType receiveType, List<OrderItem> orderItems);
}
