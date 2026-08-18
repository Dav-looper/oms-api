package com.jonathan.portfolio.order_management_system.domain.model;

public record Password(String hashedValue) {
    public Password {
        if (hashedValue == null || hashedValue.isBlank()) {
            throw new IllegalArgumentException("The password mustn't be empty");
        }
    }
}
