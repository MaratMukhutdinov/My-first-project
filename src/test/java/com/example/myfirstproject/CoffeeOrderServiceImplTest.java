package com.example.myfirstproject;

import com.example.dto.CoffeeDto;
import com.example.entity.Coffee;
import com.example.mapper.ResponseCoffeeDtoMapper;
import com.example.mapper.ResponseCoffeeDtoMapperImpl;
import com.example.repository.CoffeeRepository;
import com.example.service.CoffeeService;
import com.example.service.impl.CoffeeServiceImpl;
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
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ResponseCoffeeDtoMapperImpl.class})
public class CoffeeOrderServiceImplTest {

    private final Coffee coffee = new Coffee();
    private final List<Coffee> coffeeList = new ArrayList<>();

    @Mock
    private CoffeeRepository coffeeRepository;
    @Autowired
    private ResponseCoffeeDtoMapper responseCoffeeDtoMapper;

    private CoffeeService coffeeService;

    @Before
    public void setUp() {
        coffeeService = new CoffeeServiceImpl(coffeeRepository, responseCoffeeDtoMapper);

        coffee.setName("Test coffeeOrder");
        coffee.setBalance(1L);
        coffeeList.add(coffee);

        when(coffeeRepository.findAllByDeletedFalse()).thenReturn(coffeeList);
    }

    @Test
    public void getProductsTest() {
        List<CoffeeDto> productList = coffeeService.getCoffeeList();

        assertEquals(1, productList.size());
    }
}
