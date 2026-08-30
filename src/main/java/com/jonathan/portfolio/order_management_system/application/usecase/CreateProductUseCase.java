package com.jonathan.portfolio.order_management_system.application.usecase;

import com.jonathan.portfolio.order_management_system.domain.ports.ProductPort;
import com.jonathan.portfolio.order_management_system.domain.model.Product;

public class CreateProductUseCase {
    private ProductPort productPort;

    public CreateProductUseCase(ProductPort productPort) {
        this.productPort = productPort;
    }

    public Product execute() {
        return null;
    };
}
