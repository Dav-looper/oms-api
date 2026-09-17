package com.jonathan.portfolio.order_management_system.domain.model;

import com.jonathan.portfolio.order_management_system.domain.exceptions.InvalidStatusException;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Email email;
    private Password password;
    private Role role;
    private boolean isActive;

    public User(String name, Email email, Password password, Role role) {
        this.id = UUID.randomUUID();
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.password = Objects.requireNonNull(password, "Password cannot be empty");
        this.role = Objects.requireNonNull(role, "User must have a role");
        this.isActive = true;
    }

    public boolean hasRole(Role role) {
        if (this.role == role) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void deactivate() {
        if (!this.isActive) throw new IllegalArgumentException("The user is already unactive");
        this.isActive = false;
    }

    public void activate() {
        if (this.isActive) throw new IllegalArgumentException("The user is already active");
    }

    public Password getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User user)) return false;
        return this.id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
