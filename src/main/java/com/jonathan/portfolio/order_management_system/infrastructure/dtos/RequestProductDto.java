package com.jonathan.portfolio.order_management_system.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Currency;

public record RequestProductDto(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Amount is required")
        @Positive(message = "Amount must be greater than zero")
        BigDecimal amount,

        @NotNull(message = "Currency is required")
        Currency currency
        ) {}
