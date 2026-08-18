package com.jonathan.portfolio.order_management_system.domain.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public record Money(BigDecimal amount, Currency currency) {
    public Money {
        if (amount == null || currency == null) {
            throw new IllegalArgumentException("Ninguno de los campos puede ser nulo");
        }
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("The amount of money can't be negative");
        }
    }

    public Money multiplyBy(int quantity) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(quantity)), this.currency);
    }

    public Money operateDiscount(BigDecimal discountBetwenZeroAndOne) {
        Objects.requireNonNull(discountBetwenZeroAndOne, "El descuento no puede ser nulo");
        if (discountBetwenZeroAndOne.compareTo(BigDecimal.ZERO) < 0 || discountBetwenZeroAndOne.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("el descuento no puede ser menor a 0 ni mayor a 1, use decimales");
        }
        return new Money(this.amount.multiply(BigDecimal.ONE.subtract(discountBetwenZeroAndOne)), this.currency);
    }

    public Money sum(Money money) {
        if (!(this.currency.equals(money.currency))) {
            throw new IllegalArgumentException("La monedas deben ser iguales");
        }
        return new Money(this.amount.add(money.amount), this.currency);
    }

    public Currency getCurrency() {
        return this.currency;
    }
}