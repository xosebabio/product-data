package com.example.products.data.infrastructure.api;

import com.example.products.data.application.dto.ProductDto;
import com.example.products.data.application.usecases.find.*;
import com.example.products.data.domain.exceptions.NoExistingProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController implements ProductsApi {

    private final FindAllProductsQueryHandler findAllHandler;
    private final FindProductByIdQueryHandler findByIdHandler;
    private final FindProductByNameQueryHandler findByNameHandler;

    @Override
    public ResponseEntity<List<ProductDto>> findAll() {
        FindAllProductsQueryResponse response = findAllHandler.handle(new FindAllProductsQuery());
        return ResponseEntity.ok(response.productDtos());
    }

    @Override
    public ResponseEntity<ProductDto> findById(String id) {
        try{
            FindProductByIdQueryResponse response = findByIdHandler.handle(new FindProductByIdQuery(id));
            return ResponseEntity.ok(response.productDto());
        } catch (NoExistingProductException e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ProductDto> findByName(String name) {
        FindProductByNameQueryResponse response = findByNameHandler.handle(new FindProductByNameQuery(name));
        return ResponseEntity.ok(response.product());
    }
}