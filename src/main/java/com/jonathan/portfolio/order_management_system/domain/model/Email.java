package com.jonathan.portfolio.order_management_system.domain.model;

public record Email(String value) {
    public Email{
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email value mustn't be empty");
        }
    }
}
