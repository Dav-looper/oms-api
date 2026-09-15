package com.jonathan.portfolio.order_management_system.application.ports.out;

import com.jonathan.portfolio.order_management_system.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderPort {
    Order saveOrder(Order order);
    Optional<Order> findOrderById(UUID id);
}