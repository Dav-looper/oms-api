package com.jonathan.portfolio.order_management_system.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record Money(BigDecimal amount, Currency currency) {
    public Money {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Either the amount or currency cannot be null");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount of money can't be negative");
        }
    }

    public Money multiplyBy(int quantity) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(quantity)), this.currency);
    }

    public Money operateDiscount(BigDecimal discountBetwenZeroAndOne) {
        Objects.requireNonNull(discountBetwenZeroAndOne, "Discount cannot be null");
        if (discountBetwenZeroAndOne.compareTo(BigDecimal.ZERO) < 0 || discountBetwenZeroAndOne.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("Discount must be a decimal between zero and one");
        }
        return new Money(this.amount.multiply(BigDecimal.ONE.subtract(discountBetwenZeroAndOne)), this.currency);
    }

    public Money sum(Money money) {
        if (!(this.currency.equals(money.currency))) {
            throw new IllegalArgumentException("The currency must be the same");
        }
        return new Money(this.amount.add(money.amount), this.currency);
    }

    public Currency getCurrency() {
        return this.currency;
    }
}