package com.example.products.data.domain.product.valueobject;

import java.time.LocalDateTime;

public record PriceSnapshot(Double price, LocalDateTime recordedAt) {
}
