package com.jonathan.portfolio.order_management_system.domain.model;

import com.jonathan.portfolio.order_management_system.domain.exceptions.InvalidCurrencyException;

import java.util.Currency;
import java.util.Objects;

public record OrderItem(Product product, int quantity, Money unitPrice) {
    public OrderItem{
        product = Objects.requireNonNull(product, "El producto no puede ser nulo");

        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad no puede ser igual o menor a 0");
        }
        unitPrice = Objects.requireNonNull(unitPrice, "El precio unitario no puede ser nulo");

        if (!(product.getCurrency().equals(unitPrice.getCurrency()))) {
            throw new InvalidCurrencyException();
        }
    }

    public Money getItemTotal() {
        return this.unitPrice.multiplyBy(quantity);
    }

    public Currency getCurrency() {
        return unitPrice.getCurrency();
    }
}
