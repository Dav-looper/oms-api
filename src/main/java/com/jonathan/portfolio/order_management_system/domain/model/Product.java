package com.jonathan.portfolio.order_management_system.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private Money price;

    public Product(UUID id, String name, Money price) {
        this.id = UUID.randomUUID();
        this.name = Objects.requireNonNull(name, "Product name cannot be null").trim();
        this.price = Objects.requireNonNull(price, "El precio no puede ser nulo");
    }

    public Money getPrice() {
        return price;
    }

    public Product addDiscount(BigDecimal discount) {
        return new Product(this.id, this.name, this.price.operateDiscount(discount));
    }

    public UUID getId() {
        return id;
    }

    public Currency getCurrency() {
        return price.getCurrency();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product product)) return false;
        return this.id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
