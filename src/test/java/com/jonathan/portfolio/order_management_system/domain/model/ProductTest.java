package com.jonathan.portfolio.order_management_system.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

public class ProductTest {
    @Test
    void shouldReturnValueWithDiscountApplied() {
        //Arrange
        Product product = new Product("Rice", new Money(BigDecimal.valueOf(10.0), Currency.getInstance(Locale.US)));

        //Act
        product.addDiscount(BigDecimal.valueOf(0.1));

        //Assert
        Assertions.assertEquals(0, new BigDecimal("9.0").compareTo(product.getPrice().amount()), "The discount wasn't correctly applied");
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        //Arrange - Act - Assert
        Assertions.assertThrows(NullPointerException.class, () -> {new Product(null, new Money(BigDecimal.valueOf(10.0), Currency.getInstance(Locale.US)));}, "The exception doesn't match the expected exception");
    }

    @Test
    void shouldThrowExceptionWhenPriceIsNull() {
        //Arrange - Act - Assert
        Assertions.assertThrows(NullPointerException.class, () -> {new Product("Juan", null);}, "The exception doesn't match the expected exception");
    }
}
