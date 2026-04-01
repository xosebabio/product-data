package com.example.products.data.infrastructure.mappers;

import com.example.products.data.domain.product.Product;
import com.example.products.data.infrastructure.persistence.ProductMongodb;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toDomain(ProductMongodb product);
    ProductMongodb toMongo(Product product);
}
