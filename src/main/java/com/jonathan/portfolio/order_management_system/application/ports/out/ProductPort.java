package com.jonathan.portfolio.order_management_system.application.ports.out;

import com.jonathan.portfolio.order_management_system.domain.model.Product;

public interface ProductPort {
    Product save(Product product);
}
