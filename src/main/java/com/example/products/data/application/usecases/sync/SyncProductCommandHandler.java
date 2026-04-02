package com.example.products.data.application.usecases.sync;

import com.example.products.data.application.assemblers.ProductAssembler;
import com.example.products.data.domain.product.Product;
import com.example.products.data.domain.product.ProductFactory;
import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
public class SyncProductCommandHandler {
    private final ProductRepository productRepository;

    @Transactional
    SyncProductCommandResponse handle(SyncProductCommand command){
        Product product;
        Optional<Product> opProduct = productRepository.findByName(command.name());

        if (opProduct.isPresent()){
            product=opProduct.get();

            if (!product.getDescription().equals(command.description()))
                product.changeDescription(command.description());
            if (!product.getPrice().equals(command.price()))
                product.addPriceSnapshot(command.price());

            productRepository.save(product);

        } else {
            Product newProduct = ProductFactory.createProduct(command.name(), command.description(), command.price());
            product = productRepository.save(newProduct);
        }

        return new SyncProductCommandResponse(ProductAssembler.toDto(product));
    }
}
