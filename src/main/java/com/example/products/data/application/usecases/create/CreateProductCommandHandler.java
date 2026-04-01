package com.example.products.data.application.usecases.create;

import com.example.products.data.application.assemblers.ProductAssembler;
import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.domain.product.Product;
import com.example.products.data.domain.product.ProductFactory;
import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CreateProductCommandHandler {
    private final ProductRepository productRepository;

    @Transactional
    CreateProductCommandResponse handle(CreateProductCommand command){
        Product product = ProductFactory.createProduct(command.name(), command.description(), command.price());
        Product productCreated = productRepository.save(product);
        return new CreateProductCommandResponse(ProductAssembler.toDto(productCreated));
    }
}
