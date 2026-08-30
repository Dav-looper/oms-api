package com.jonathan.portfolio.order_management_system.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.UUID;

public class OrderTest {
    //Validate monetary consistency
    @Test
    void shouldCalculateTotalForMultipleItems() {
        //Arrange
        User user = new User(UUID.randomUUID(), "David Armando", new Email("Rolando@gmail.com"), new Password("$2a$12$R9h/cIPz0gi.URNNX3kh2OPST9/PgBkqquzi.Ss7KIUgO2t0jWMUWa"), Role.CUSTOMER);
        Product product1 = new Product("arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));
        Product product2 = new Product("carne", new Money(BigDecimal.valueOf(13.00), Currency.getInstance(Locale.US)));
        OrderItem orderItem = new OrderItem(product1, 1, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(product2, 1, product2.getPrice());
        Order order = new Order(UUID.randomUUID(), Currency.getInstance(Locale.US), user);

        order.addItem(orderItem);
        order.addItem(orderItem2);

        Money resultadoEsperado = new Money(BigDecimal.valueOf(23.00), Currency.getInstance(Locale.US));

        //Act
        Money resultadoReal = order.getTotal();

        //Assert
        Assertions.assertEquals(resultadoEsperado, resultadoReal, "Resultado no coincide");
    }

    @Test
    void shouldReturnZeroWhenOrderHasNoItems() {
        //Arrange
        User user = new User(UUID.randomUUID(), "David Armando", new Email("Rolando@gmail.com"), new Password("$2a$12$R9h/cIPz0gi.URNNX3kh2OPST9/PgBkqquzi.Ss7KIUgO2t0jWMUWa"), Role.CUSTOMER);
        Order order = new Order(UUID.randomUUID(), Currency.getInstance(Locale.US), user);

        Money resultadoEsperado = new Money(BigDecimal.valueOf(0.00), Currency.getInstance(Locale.US));

        //Act
        Money resultadoReal = order.getTotal();

        //Assert
        Assertions.assertEquals(resultadoEsperado, resultadoReal, "El resultado deberia ser 0");
    }

    @Test
    void shouldMergeQuantitiesForDuplicatedProducts() {
        //Arrange
        User user = new User(UUID.randomUUID(), "David Armando", new Email("Rolando@gmail.com"), new Password("$2a$12$R9h/cIPz0gi.URNNX3kh2OPST9/PgBkqquzi.Ss7KIUgO2t0jWMUWa"), Role.CUSTOMER);
        Product product1 = new Product("arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));
        OrderItem orderItem = new OrderItem(product1, 1, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(product1, 1, product1.getPrice());
        Order order = new Order(UUID.randomUUID(), Currency.getInstance(Locale.US), user);

        order.addItem(orderItem);
        order.addItem(orderItem2);

        int resultadoEsperado = 1;

        //Act
        int resultadoReal = order.getItemsQuantity();

        //Assert
        Assertions.assertEquals(resultadoEsperado, resultadoReal, "El resultado no coincide");
    }

    @Test
    void shouldAddQuantityToTheSameProductForDuplicatedProducts() {
        //Arrange
        User user = new User(UUID.randomUUID(), "David Armando", new Email("Rolando@gmail.com"), new Password("$2a$12$R9h/cIPz0gi.URNNX3kh2OPST9/PgBkqquzi.Ss7KIUgO2t0jWMUWa"), Role.CUSTOMER);
        Product product1 = new Product("arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));
        OrderItem orderItem = new OrderItem(product1, 1, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(product1, 1, product1.getPrice());
        Order order = new Order(UUID.randomUUID(), Currency.getInstance(Locale.US), user);

        order.addItem(orderItem);
        order.addItem(orderItem2);

        int expectedResult = 2;

        //Act
        int realResult = order.getProductQuantityPerItem(product1.getId());

        //Assert
        Assertions.assertEquals(expectedResult, realResult, "The item products quantity isn't correct");
    }

    //Validate aggregate lifecycle rules
    @Test
    void shouldPayOrderSuccessfully() {
        //Arrange
        User user = new User(UUID.randomUUID(), "David Armando", new Email("Rolando@gmail.com"), new Password("$2a$12$R9h/cIPz0gi.URNNX3kh2OPST9/PgBkqquzi.Ss7KIUgO2t0jWMUWa"), Role.CUSTOMER);
        Product product1 = new Product("arroz", new Money(BigDecimal.valueOf(10.00), Currency.getInstance(Locale.US)));
        Product product2 = new Product("carne", new Money(BigDecimal.valueOf(13.00), Currency.getInstance(Locale.US)));
        OrderItem orderItem = new OrderItem(product1, 1, product1.getPrice());
        OrderItem orderItem2 = new OrderItem(product2, 1, product2.getPrice());
        Order order = new Order(UUID.randomUUID(), Currency.getInstance(Locale.US), user);

        order.addItem(orderItem);
        order.addItem(orderItem2);

        OrderStatus expectedResult = OrderStatus.PAID;

        //Act
        order.pay(new Money(BigDecimal.valueOf(23.00), Currency.getInstance(Locale.US)));
        OrderStatus realResult = OrderStatus.PAID;

        //Assert
        Assertions.assertEquals(expectedResult, realResult, "The status didn't change to paid status");
    }
}
