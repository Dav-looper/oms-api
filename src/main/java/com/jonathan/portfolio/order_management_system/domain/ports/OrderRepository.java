package com.jonathan.portfolio.order_management_system.domain.ports;

import com.jonathan.portfolio.order_management_system.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order saveOrder(Order order);
    Optional<Order> findOrderById(UUID id);
}