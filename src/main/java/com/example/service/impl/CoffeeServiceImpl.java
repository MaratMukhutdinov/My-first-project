package com.example.service.impl;

import com.example.dto.CoffeeDto;
import com.example.dto.RequestCoffeeCountChangeDto;
import com.example.entity.Coffee;
import com.example.mapper.ResponseCoffeeDtoMapper;
import com.example.repository.CoffeeRepository;
import com.example.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    private final ResponseCoffeeDtoMapper responseCoffeeDtoMapper;

    @Override
    public List<CoffeeDto> getCoffeeList() {
        List<Coffee> allCoffee = coffeeRepository.findAllByDeletedFalse();
        return responseCoffeeDtoMapper.toDto(allCoffee).stream()
              .sorted(Comparator.comparing(CoffeeDto::getName))
              .collect(Collectors.toList());
    }

    @Override
    public void addCoffee(RequestCoffeeCountChangeDto coffeeDto) {
        Optional<Coffee> coffeeOpt = coffeeRepository.findById(coffeeDto.getCoffeeId());
        if (coffeeOpt.isPresent()) {
            Coffee coffee = coffeeOpt.get();
            coffee.setBalance(coffee.getBalance() + coffeeDto.getCount());
            coffeeRepository.save(coffee);
            log.info("Coffee with id: " + coffee.getId() + " was updated!");
        } else {
            log.warn("Coffee with id: " + coffeeDto.getCoffeeId() + " was not found!");
        }
    }

    @Override
    public boolean removeCoffee(RequestCoffeeCountChangeDto coffeeDto) {
        Optional<Coffee> coffeeOpt = coffeeRepository.findById(coffeeDto.getCoffeeId());
        if (coffeeOpt.isPresent()) {
            Coffee coffee = coffeeOpt.get();
            long result = coffee.getBalance() - coffeeDto.getCount();
            if (result > 0) {
                coffee.setBalance(coffee.getBalance() - coffeeDto.getCount());
                coffeeRepository.save(coffee);
                log.info("Coffee with id: " + coffee.getId() + " was updated!");
                return true;
            }
        }
        return false;
    }
}
