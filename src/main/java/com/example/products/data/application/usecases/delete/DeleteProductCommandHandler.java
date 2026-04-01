package com.example.products.data.application.usecases.delete;

import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteProductCommandHandler {

    private final ProductRepository productRepository;

    @Transactional
    public void handle(DeleteProductCommand command){
        productRepository.deleteById(UUID.fromString(command.id()));
    }
}
