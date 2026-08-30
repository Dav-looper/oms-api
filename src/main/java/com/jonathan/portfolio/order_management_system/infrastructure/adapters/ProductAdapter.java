package com.jonathan.portfolio.order_management_system.infrastructure.adapters;

import com.jonathan.portfolio.order_management_system.domain.ports.ProductPort;
import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.entities.ProductEntity;
import com.jonathan.portfolio.order_management_system.infrastructure.repositories.JpaProductRepository;

public class ProductAdapter implements ProductPort {
    private JpaProductRepository jpaProductRepository;

    public ProductAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public ProductEntity save(Product product) {
        return null;
    }
}
