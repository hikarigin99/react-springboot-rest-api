package com.example.gccoffee.order.repository;

import com.example.gccoffee.order.service.vo.Order;

public interface OrderRepository {

    Order insert(Order order);
}
