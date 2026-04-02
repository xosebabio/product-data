package com.example.products.data.domain.repository;

import com.example.products.data.domain.product.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {
    Product findById(UUID id);
    List<Product> findAll();
    Product save(Product product);
    void deleteById(UUID id);
    Product findByName(String name);
}
