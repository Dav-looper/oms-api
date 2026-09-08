package com.jonathan.portfolio.order_management_system.infrastructure.adapters;

import com.jonathan.portfolio.order_management_system.domain.ports.ProductPort;
import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.entities.ProductEntity;
import com.jonathan.portfolio.order_management_system.infrastructure.mappers.ProductMapper;
import com.jonathan.portfolio.order_management_system.infrastructure.repositories.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductAdapter implements ProductPort {
    private final ProductMapper productMapper;
    private JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductAdapter(JpaProductRepository jpaProductRepository, ProductMapper productMapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productJpaEntity = productMapper.domainEntityToJpaEntity(product);
        ProductEntity savedProductEntity = jpaProductRepository.save(productJpaEntity);
        return productMapper.jpaEntityToDomainEntity(savedProductEntity);
    }
}
