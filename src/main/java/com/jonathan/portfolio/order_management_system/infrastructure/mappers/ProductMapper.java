package com.jonathan.portfolio.order_management_system.infrastructure.mappers;

import com.jonathan.portfolio.order_management_system.domain.model.Product;
import com.jonathan.portfolio.order_management_system.infrastructure.dtos.ResponseProductDto;
import com.jonathan.portfolio.order_management_system.infrastructure.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity domainEntityToJpaEntity(Product product);

    Product jpaEntityToDomainEntity(ProductEntity productEntity);

    @Mapping(source = "price.amount", target = "amount")
    @Mapping(source = "price.currency", target = "currency")
    ResponseProductDto domainEntityToDto(Product product);
}