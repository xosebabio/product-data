package com.example.products.data.application.usecases.find;

import com.example.products.data.application.assemblers.ProductAssembler;
import com.example.products.data.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class FindProductByNameQueryHandler {

    private final ProductRepository productRepository;

    @Transactional
    public FindProductByNameQueryResponse handle(FindProductByNameQuery query){
        return new FindProductByNameQueryResponse(ProductAssembler.toDto(productRepository.findByName(query.name())));
    }
}
