package com.example.gccoffee.order.service;

import com.example.gccoffee.order.vo.Order;
import com.example.gccoffee.order.vo.ReceiveType;
import com.example.gccoffee.order.vo.OrderItem;
import com.example.gccoffee.order.vo.OrderStatus;
import com.example.gccoffee.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(String phoneNumber, OrderStatus orderStatus, ReceiveType receiveType, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), phoneNumber, orderStatus, receiveType, orderItems, LocalDateTime.now(), LocalDateTime.now());
        return orderRepository.insert(order);
    }
}
