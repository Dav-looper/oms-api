package com.jonathan.portfolio.order_management_system.infrastructure.repositories;

import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {
}
