package com.jonathan.portfolio.order_management_system.application.usecase;

import com.jonathan.portfolio.order_management_system.domain.model.Money;
import com.jonathan.portfolio.order_management_system.domain.ports.ProductPort;
import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.RequestProductDto;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.ResponseProductDto;
import com.jonathan.portfolio.order_management_system.infrastructure.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCase {
    private ProductPort productPort;
    private ProductMapper productMapper;

    @Autowired
    public CreateProductUseCase(ProductPort productPort, ProductMapper productMapper) {
        this.productPort = productPort;
        this.productMapper = productMapper;
    }

    public ResponseProductDto execute(RequestProductDto requestProductDto) {
        Money productPrice = new Money(requestProductDto.amount(), requestProductDto.currency());
        Product product = new Product(requestProductDto.name(), productPrice);
        Product productSaved = productPort.save(product);
        return productMapper.domainEntityToDto(productSaved);
    };
}