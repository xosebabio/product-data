package com.example.products.data.domain.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    Product(String name, Double price, String description){
        if (name.isBlank() || price.isNaN()|| price<=0 || description.isBlank()){
            throw new IllegalArgumentException("The arguments to create a product must be valid\n" +
                    "Arguments: name=" + name + ", price=" + price + ", description=" + description);
        }
        this.id = UUID.randomUUID();
        this.description = description;
        this.name = name;
        this.price = price;
        this.createAt = LocalDateTime.now();
    }

    void changePrice(Double price){
        if (price.isNaN() || price<=0){
            throw new IllegalArgumentException("Price must be a positive number");
        }
        this.price = price;
        this.updatedAt = LocalDateTime.now();
    }

    void changeDescription(String description) {
        if (description==null || description.isBlank()){
            throw new IllegalArgumentException("Description must not be null or blank");
        }
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }
}
