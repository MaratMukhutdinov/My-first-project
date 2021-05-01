package com.example.service;

import com.example.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();

    void addCoffee(ProductDto productDto);

    void removeCoffee(ProductDto productDto);
}
