package com.example.products.data.application.usecases.create;

public record CreateProductCommand(String name, Double price, String description) {
}
