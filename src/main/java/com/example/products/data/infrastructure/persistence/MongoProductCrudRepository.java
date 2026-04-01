package com.example.products.data.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoProductCrudRepository extends MongoRepository<ProductMongodb, UUID> {
}
