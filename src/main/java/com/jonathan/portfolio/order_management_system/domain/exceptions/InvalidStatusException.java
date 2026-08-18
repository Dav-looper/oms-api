package com.jonathan.portfolio.order_management_system.domain.exceptions;

import com.jonathan.portfolio.order_management_system.domain.model.OrderStatus;

public class InvalidStatusException extends RuntimeException {
    private OrderStatus currentStatus;
    private OrderStatus expectedStatus;

    public InvalidStatusException(OrderStatus currentStatus, OrderStatus expectedStatus) {
        super(String.format("The status $%s is not valid, the expected status is: $%s", currentStatus, expectedStatus));
        this.currentStatus = currentStatus;
        this.expectedStatus = expectedStatus;
    }
}
