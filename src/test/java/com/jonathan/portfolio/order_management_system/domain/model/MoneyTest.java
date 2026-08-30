package com.jonathan.portfolio.order_management_system.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public class MoneyTest {
    @Test
    void shouldThrowExceptionWhenAmountIsLessThanZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(BigDecimal.valueOf(-1.0), Currency.getInstance(Locale.US)), "Doesn't throw exception when amount is less than zero");
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(null, Currency.getInstance(Locale.US)), "Doesn't throw exception when amount is null");
    }

    @Test
    void shouldThrowExceptionWhenCurrencyIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Money(BigDecimal.valueOf(1.00), null), "Doesn't throw exception when amount is null");
    }
}
