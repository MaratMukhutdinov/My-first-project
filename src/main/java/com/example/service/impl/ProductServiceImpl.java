package com.example.service.impl;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.mapper.ResponseProductDtoMapper;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ResponseProductDtoMapper responseProductDtoMapper;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> allProducts = productRepository.findAll();
        return responseProductDtoMapper.toDto(allProducts);
    }

    @Override
    public void addCoffee(ProductDto productDto) {

        Optional<Product> existingProductOpt = productRepository.findByName(productDto.getName());

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setCount(existingProduct.getCount() + productDto.getCount());
            productRepository.save(existingProduct);
            log.info(productDto.getName() + " count was updated!");
        } else {
            productRepository.save(responseProductDtoMapper.toEntity(productDto));
            log.info("New coffee: " + productDto.getName() + " was added");
        }
    }
}
