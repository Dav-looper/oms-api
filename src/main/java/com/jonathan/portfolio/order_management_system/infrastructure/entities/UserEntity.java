package com.jonathan.portfolio.order_management_system.infrastructure.entities;

import com.jonathan.portfolio.order_management_system.domain.model.Role;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, length = 200)
    private String name;

    @Embedded
    @Column(nullable = false)
    private EmailEntity email;

    @Embedded
    @Column(nullable = false)
    private PasswordEntity password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public UserEntity() {}

    public UserEntity(UUID id, String name, EmailEntity email, PasswordEntity password, Role role, boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
    }
}
