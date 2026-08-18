package com.jonathan.portfolio.order_management_system.domain.exceptions;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException() {
        super("The quantity is invalid");
    }
}
