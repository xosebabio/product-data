package com.example.products.data.application.usecases.find;

import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
public class FindProductByIdQueryHandler {
    private final ProductRepository productRepository;

    @Transactional
    public FindProductByIdQueryResponse handle(FindProductByIdQuery query){
        ProductDto productDto = productRepository.findById(UUID.fromString(query.id()));
        return new FindProductByIdQueryResponse(productDto);
    }
}
