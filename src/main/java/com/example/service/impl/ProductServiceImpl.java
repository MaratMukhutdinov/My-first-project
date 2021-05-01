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
        List<Product> allProducts = productRepository.findAllByDeletedFalse();
        return responseProductDtoMapper.toDto(allProducts);
    }

    @Override
    public void addCoffee(ProductDto productDto) {

        Optional<Product> existingProductOpt = productRepository.findByName(productDto.getName());

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            if (existingProduct.getDeleted()) {
                existingProduct.setDeleted(false);
            }
            existingProduct.setCount(existingProduct.getCount() + productDto.getCount());
            productRepository.save(existingProduct);
            log.info(productDto.getName() + " count was updated!");
        } else {
            productRepository.save(responseProductDtoMapper.toEntity(productDto));
            log.info("New coffee: " + productDto.getName() + " was added");
        }
    }

    @Override
    public void removeCoffee(ProductDto coffeeToRemove) {

        Optional<Product> productOpt = productRepository.findByName(coffeeToRemove.getName());

        if (productOpt.isPresent()) {
            Product existingCoffee = productOpt.get();
            if (coffeeToRemove.getCount() < existingCoffee.getCount()) {
                existingCoffee.setCount(existingCoffee.getCount() - coffeeToRemove.getCount());
                productRepository.save(existingCoffee);
            } else if (coffeeToRemove.getCount().equals(existingCoffee.getCount())) {
                existingCoffee.setCount(0);
                existingCoffee.setDeleted(true);
                productRepository.save(existingCoffee);
            } else {
                log.info("Remove count is more than we have");
            }
        } else {
            log.info("Coffee with name: " + coffeeToRemove.getName() + " wasn't found");
        }
    }
}
