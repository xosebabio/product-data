package com.example.products.data.infrastructure.persistence;

import com.example.products.data.domain.product.Product;
import com.example.products.data.domain.repository.ProductRepository;
import com.example.products.data.infrastructure.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository{
    private final ProductMapper mapper;
    private final MongoProductCrudRepository productCrudRepository;

    @Override
    public Product findById(UUID id) {
        ProductMongodb productMongodb = productCrudRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return mapper.toDomain(productMongodb);
    }

    @Override
    public List<Product> findAll() {
        List<ProductMongodb> products = productCrudRepository.findAll();
        return products.stream().map(mapper::toDomain).toList();
    }

    @Override
    public Product save(Product product) {
        log.info("Saving product {}", product);
        ProductMongodb productMongodb = productCrudRepository.save(mapper.toMongo(product));
        return mapper.toDomain(productMongodb);
    }

    @Override
    public void deleteById(UUID id) {
        productCrudRepository.deleteById(id);
        log.info("Product with id {} deleted", id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        Optional<ProductMongodb> opProduct = productCrudRepository.findByName(name);
        if (opProduct.isEmpty()){
            return Optional.empty();
        }
        return opProduct.map(mapper::toDomain);
    }
}
