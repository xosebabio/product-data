package com.example.products.data.infrastructure.persistence;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Document(collection = "products")
@Value
@Builder
public class ProductMongodb {
    @Id
    UUID id;
    String name;
    String description;
    Double price;
    LocalDateTime createAt;
    LocalDateTime updatedAt;
}
