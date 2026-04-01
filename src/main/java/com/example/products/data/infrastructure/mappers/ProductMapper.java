package com.example.products.data.infrastructure.mappers;

import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.infrastructure.persistence.ProductMongodb;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(ProductMongodb product);
    ProductMongodb toMongo(ProductDto productDto);
}
