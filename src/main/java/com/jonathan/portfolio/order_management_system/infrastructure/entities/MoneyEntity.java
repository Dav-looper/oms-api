package com.jonathan.portfolio.order_management_system.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.util.Currency;

@Embeddable
public class MoneyEntity {
    @Column(name = "price")
    BigDecimal amount;
    Currency currency;

    public MoneyEntity() {}

    public MoneyEntity(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
