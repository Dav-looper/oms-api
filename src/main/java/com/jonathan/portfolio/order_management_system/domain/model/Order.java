package com.jonathan.portfolio.order_management_system.domain.model;

import com.jonathan.portfolio.order_management_system.domain.exceptions.InvalidCurrencyException;
import com.jonathan.portfolio.order_management_system.domain.exceptions.InvalidStatusException;

import java.math.BigDecimal;
import java.util.*;

public class Order {
    private UUID id;
    private final Map<UUID, OrderItem> items;
    private User user;
    private OrderStatus status;
    private Currency orderCurrency;

    public Order(UUID id, Currency orderCurrency, User user) {
        this.id = Objects.requireNonNull(id, "El id no puede ser nulo");
        this.orderCurrency = Objects.requireNonNull(orderCurrency, "La divisa no puede ser nula");
        this.items = new HashMap<>();
        this.user = Objects.requireNonNull(user, "El cliente no puede ser nulo");
        this.status = OrderStatus.CREATED;
    }

    public void addItem(OrderItem item) {
        if (this.status != OrderStatus.CREATED) {
            throw new InvalidStatusException(this.status, OrderStatus.CREATED);
        }

        item = Objects.requireNonNull(item, "El item no puede ser nulo");
        UUID id = item.product().getId();

        if (!(item.getCurrency().equals(orderCurrency))) {
            throw new InvalidCurrencyException();
        }

        if (this.items.containsKey(id)) {
            int total = this.items.get(id).quantity() + item.quantity();
            this.items.remove(id);
            this.items.put(id, new OrderItem(item.product(), total, item.unitPrice()));
        } else {
            this.items.put(id, item);
        }
    }

    public Money getTotal() {
        if (this.items.isEmpty()) {
            return new Money(BigDecimal.valueOf(0.00), orderCurrency);
        }
        List<Money> itemsPrices = items.values().stream()
                .map(i -> i.getItemTotal())
                .toList();

        return itemsPrices.stream()
                .reduce((acc, curr) -> acc.sum(curr))
                .get();
    }

    public int getItemsQuantity() {
        return items.size();
    }

    public int getProductQuantityPerItem(UUID itemId) {
        return items.get(itemId).quantity();
    }

    public void pay(Money money) {
        if (this.status != OrderStatus.CREATED) {
            throw new InvalidStatusException(this.status, OrderStatus.CREATED);
        }
        if (money.amount().compareTo(this.getTotal().amount()) < 0) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }
        if (!money.currency().equals(this.orderCurrency)) {
            throw new IllegalArgumentException("La moneda no puede ser diferente");
        }
        this.status = OrderStatus.PAID;
    }

    public void cancel() {
        if (this.status != OrderStatus.CREATED) {
            throw new InvalidStatusException(this.status, OrderStatus.CREATED);
        }
        this.status = OrderStatus.CANCELLED;
    }

    public void ship() {
        if (this.status != OrderStatus.PAID) {
            throw new InvalidStatusException(this.status, OrderStatus.PAID);
        }
        this.status = OrderStatus.SHIPPED;
    }

    public UUID getId() {
        return this.id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order order)) return false;
        return this.id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
