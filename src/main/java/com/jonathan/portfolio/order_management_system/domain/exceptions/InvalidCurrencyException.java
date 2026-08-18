package com.jonathan.portfolio.order_management_system.domain.exceptions;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException() {
        super("Currency cannot be different");
    }
}
