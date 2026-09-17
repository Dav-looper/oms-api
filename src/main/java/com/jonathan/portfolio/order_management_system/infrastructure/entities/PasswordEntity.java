package com.jonathan.portfolio.order_management_system.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PasswordEntity {
    @Column(name = "password")
    String hashedValue;

    public PasswordEntity() {}

    public PasswordEntity(String hashedValue) {
        this.hashedValue = hashedValue;
    }

    public String getHashedValue() {
        return hashedValue;
    }
}
