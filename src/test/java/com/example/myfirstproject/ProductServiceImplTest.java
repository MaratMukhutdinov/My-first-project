package com.example.myfirstproject;

import com.example.dto.ProductDto;
import com.example.entity.Product;
import com.example.mapper.ResponseProductDtoMapper;
import com.example.mapper.ResponseProductDtoMapperImpl;
import com.example.repository.ProductRepository;
import com.example.service.ProductService;
import com.example.service.impl.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ResponseProductDtoMapperImpl.class})
public class ProductServiceImplTest {

    private final Product product = new Product();
    private final List<Product> productList = new ArrayList<>();

    @Mock
    private ProductRepository productRepository;
    @Autowired
    private ResponseProductDtoMapper responseProductDtoMapper;

    private ProductService productService;

    @Before
    public void setUp() {
        productService = new ProductServiceImpl(productRepository, responseProductDtoMapper);

        product.setName("Test product");
        product.setCount(1);
        productList.add(product);

        when(productRepository.findAll()).thenReturn(productList);
    }

    @Test
    public void getProductsTest() {
        List<ProductDto> productList = productService.getProducts();

        assertEquals(1, productList.size());
        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(productRepository);
    }
}
