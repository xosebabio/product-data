package com.example.products.data.application.dto;

import com.example.products.data.domain.product.valueobject.PriceSnapshot;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        Double price,
        List<PriceSnapshot> priceSnapshot,
        String description,
        LocalDateTime createAt,
        LocalDateTime updatedAt
) {
}
