package com.example.gccoffee.order.controller;

import com.example.gccoffee.order.controller.dto.CreateOrderRequest;
import com.example.gccoffee.order.service.vo.Order;
import com.example.gccoffee.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

    private final Logger logger = LoggerFactory.getLogger("OrderRestController");
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        logger.info("{} {}", orderRequest.getPhoneNumber(), orderRequest.getReceiveType());
        return orderService.createOrder(orderRequest.getPhoneNumber(), orderRequest.getOrderStatus(), orderRequest.getReceiveType(), orderRequest.getOrderItems());
    }
}
