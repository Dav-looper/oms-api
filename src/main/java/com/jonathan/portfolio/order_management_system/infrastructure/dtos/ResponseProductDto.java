package com.jonathan.portfolio.order_management_system.infrastructure.dtos;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public record ResponseProductDto(
        UUID id,
        String name,
        BigDecimal amount,
        Currency currency
) {}
