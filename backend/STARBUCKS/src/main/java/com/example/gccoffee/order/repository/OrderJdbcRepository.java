package com.example.gccoffee.order.repository;

import com.example.gccoffee.order.service.vo.Order;
import com.example.gccoffee.order.service.vo.OrderItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class OrderJdbcRepository implements OrderRepository {

    private final Logger logger = LoggerFactory.getLogger("OrderJdbcRepository");
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderJdbcRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Order insert(Order order) {
        jdbcTemplate.update("INSERT INTO orders (order_id, phone_number, order_status, receive_type, created_at, updated_at) " +
                        "VALUES (UUID_TO_BIN(:orderId), :phoneNumber, :orderStatus, :receiveType, :createdAt, :updatedAt)",
                toOrderParamMap(order));
        order.getOrderItems()
                .forEach(item -> jdbcTemplate.update("INSERT INTO order_items (order_id, product_id, category, price, quantity)" +
                                "VALUES (UUID_TO_BIN(:orderId), UUID_TO_BIN(:productId), :category, :price, :quantity)",
                        toOrderItemParamMap(order.getOrderId(), item))
                );
        return order;
    }

    private Map<String, Object> toOrderParamMap(Order order) {
        logger.info("{}", order);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderId", order.getOrderId().toString().getBytes());
        paramMap.put("phoneNumber", order.getPhoneNumber());
        paramMap.put("orderStatus", order.getOrderStatus().toString());
        paramMap.put("receiveType", order.getReceiveType().toString());
        paramMap.put("createdAt", order.getCreatedAt());
        paramMap.put("updatedAt", order.getUpdatedAt());
        return paramMap;
    }

    private Map<String, Object> toOrderItemParamMap(UUID orderId, OrderItem item) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("orderId", orderId.toString().getBytes());
        paramMap.put("productId", item.productId().toString().getBytes());
        paramMap.put("category", item.category().toString());
        paramMap.put("price", item.price());
        paramMap.put("quantity", item.quantity());
        return paramMap;
    }
}
