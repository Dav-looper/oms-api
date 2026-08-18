package com.jonathan.portfolio.order_management_system.infrastructure.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_product_name", columnList = "name")
})
public class ProductEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @Embedded
    private MoneyEntity price;

    public ProductEntity() {}

    public ProductEntity(UUID id, String name, MoneyEntity price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MoneyEntity getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}