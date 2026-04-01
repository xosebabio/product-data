package com.example.products.data.domain.product;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ProductFactory {

    public static Product createProduct(String name, String description, Double price) {
        return new Product(name, price, description);
    }
}
