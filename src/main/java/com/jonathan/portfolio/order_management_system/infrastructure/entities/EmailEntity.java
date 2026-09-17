package com.jonathan.portfolio.order_management_system.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EmailEntity {
    @Column(name = "email")
    String email;

    public EmailEntity() {}

    public EmailEntity(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
