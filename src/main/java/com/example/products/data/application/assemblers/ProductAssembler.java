package com.example.products.data.application.assemblers;

import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.domain.product.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ProductAssembler {

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getPriceSnapshot(),
                product.getDescription(),
                product.getCreateAt(),
                product.getUpdatedAt()
        );
    }

    public static Product toDomain(ProductDto productDto){
        if (productDto == null) {
            return null;
        }
        return new Product(
                productDto.id(),
                productDto.name(),
                productDto.price(),
                productDto.priceSnapshot(),
                productDto.description(),
                productDto.createAt(),
                productDto.updatedAt()
        );
    }


}
