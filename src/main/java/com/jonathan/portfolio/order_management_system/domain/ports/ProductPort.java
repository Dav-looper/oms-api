package com.jonathan.portfolio.order_management_system.domain.ports;

import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.entities.ProductEntity;

public interface ProductPort {
    Product save(Product product);
}
