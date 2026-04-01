package com.example.products.data.application.usecases.find;

import com.example.products.data.application.dto.ProductDto;

import java.util.List;

public record FindAllProductsQueryResponse(List<ProductDto> productDtos) {
}
