package com.example.products.data.infrastructure.config;

import com.example.products.data.application.usecases.find.FindAllProductsQueryHandler;
import com.example.products.data.application.usecases.find.FindProductByIdQueryHandler;
import com.example.products.data.application.usecases.find.FindProductByNameQueryHandler;
import com.example.products.data.domain.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public FindAllProductsQueryHandler findAllProductsQueryHandler(ProductRepository productRepository) {
        return new FindAllProductsQueryHandler(productRepository);
    }

    @Bean
    public FindProductByIdQueryHandler findProductByIdQueryHandler(ProductRepository productRepository) {
        return new FindProductByIdQueryHandler(productRepository);
    }

    @Bean
    public FindProductByNameQueryHandler findProductByNameQueryHandler(ProductRepository productRepository) {
        return new FindProductByNameQueryHandler(productRepository);
    }
}