package com.jonathan.portfolio.order_management_system.application.ports.in;

import com.jonathan.portfolio.order_management_system.infrastructure.dtos.RequestProductDto;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.ResponseProductDto;

public interface CreateProductInputPort {
    ResponseProductDto execute(RequestProductDto requestProductDto);
}
