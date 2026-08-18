package com.jonathan.portfolio.order_management_system.domain.model;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Email email;
    private Password password;
    private Role role;

    public User(UUID id, String name, Email email, Password password, Role role) {
        this.id = Objects.requireNonNull(id, "El id no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.password = Objects.requireNonNull(password, "Password cannot be empty");
        this.role = Objects.requireNonNull(role, "User must have a role");
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
