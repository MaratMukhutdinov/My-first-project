package com.example.service;

import com.example.dto.CoffeeDto;
import com.example.dto.RequestCoffeeCountChangeDto;

import java.util.List;

public interface CoffeeService {

    List<CoffeeDto> getCoffeeList();

    void addCoffee(RequestCoffeeCountChangeDto coffeeDto);

    boolean removeCoffee(RequestCoffeeCountChangeDto coffeeDto);
}
