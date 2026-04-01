package com.example.products.data.infrastructure.persistence;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Value
@Builder
public class ProductMongodb {
}
