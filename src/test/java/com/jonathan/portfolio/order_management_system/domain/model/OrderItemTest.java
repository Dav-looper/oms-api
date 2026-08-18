package com.jonathan.portfolio.order_management_system.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

public class OrderItemTest {
    @Test
    void shouldThrowExceptionWhenQuantityIsZero() {
        //Arrange
        Product product1 = new Product(UUID.randomUUID(), "arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));

        //Act
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new OrderItem(product1, 0, product1.getPrice()); }, "Doesn't throw Exception when quantity is zero");
    }

    @Test
    void shouldThrowExceptionWhenQuantityIsNegative() {
        //Arrange
        Product product1 = new Product(UUID.randomUUID(), "arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));

        //Act
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> { new OrderItem(product1, -2, product1.getPrice()); }, "Doesn't throw Exception when quantity is negative");
    }

    @Test
    void sholdRejectNullProduct() {
        //Arrange
        Money price = new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US));
        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> { new OrderItem(null, 2, price); }, "Doesn't throw Exception when product is null");
    }

    @Test
    void shouldRejectNullUnitPrice() {
        //Arrange
        Product product1 = new Product(UUID.randomUUID(), "arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));
        //Act
        //Assert
        Assertions.assertThrows(NullPointerException.class, () -> { new OrderItem(null, 2, null); }, "Doesn't throw Exception when unit price is null");
    }
}
