package com.example.products.data.infrastructure.api;

import com.example.products.data.application.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
public interface ProductsApi {

    @GetMapping
    ResponseEntity<List<ProductDto>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> findById(@PathVariable("id") String id);

    @GetMapping("/search")
    ResponseEntity<ProductDto> findByName(@RequestParam("name") String name);
}