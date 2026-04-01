package com.example.products.data.infrastructure.persistence;

import com.example.products.data.application.assemblers.ProductAssembler;
import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.domain.product.Product;
import com.example.products.data.domain.repository.ProductRepository;
import com.example.products.data.infrastructure.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository{
    private final ProductMapper mapper;
    private final MongoProductCrudRepository productCrudRepository;

    @Override
    public ProductDto findById(UUID id) {
        ProductMongodb productMongodb = productCrudRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return mapper.toDto(productMongodb);
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductMongodb> products = productCrudRepository.findAll();
        return products.stream().map(mapper::toDto).toList();
    }

    @Override
    public ProductDto save(ProductDto product) {
        log.info("Saving product {}", product);
        ProductMongodb productMongodb = productCrudRepository.save(mapper.toMongo(product));
        return mapper.toDto(productMongodb);
    }

    @Override
    public void deleteById(UUID id) {
        productCrudRepository.deleteById(id);
        log.info("Product with id {} deleted", id);
    }
}
