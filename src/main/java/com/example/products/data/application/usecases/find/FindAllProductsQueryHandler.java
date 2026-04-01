package com.example.products.data.application.usecases.find;

import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class FindAllProductsQueryHandler {

    private final ProductRepository productRepository;

    @Transactional
    public FindAllProductsQueryResponse handle(FindAllProductsQuery query){
        return new FindAllProductsQueryResponse(productRepository.findAll());
    }
}
