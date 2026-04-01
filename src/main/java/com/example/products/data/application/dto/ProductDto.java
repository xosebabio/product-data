package com.example.products.data.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductDto(
        UUID id,
        String name,
        Double price,
        String description,
        LocalDateTime createAt,
        LocalDateTime updatedAt
) {
}
