package com.example.mapper;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.mapper.base.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ResponseProductDtoMapper  extends EntityMapper<ProductDto, Product> {

    ProductDto toDto (Product product);

    List<ProductDto> toDto (List<Product> productList);

    Product toEntity (ProductDto productDto);

    List<Product> toEntity (List<ProductDto> productDtoList);
}
