package com.example.products.data.domain.repository;

import com.example.products.data.application.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    ProductDto findById(UUID id);
    List<ProductDto> findAll();
    ProductDto save(ProductDto product);
    void deleteById(UUID id);
}
