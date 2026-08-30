package com.jonathan.portfolio.order_management_system.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.id = UUID.randomUUID();
        this.name = Objects.requireNonNull(name, "Product name cannot be null").trim();
        this.price = Objects.requireNonNull(price, "Product price cannot be null");
    }

    public Money getPrice() {
        return price;
    }

    public void addDiscount(BigDecimal discount) {
        this.price = this.price.operateDiscount(discount);
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
