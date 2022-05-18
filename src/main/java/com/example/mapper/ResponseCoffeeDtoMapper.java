package com.example.mapper;

import com.example.dto.CoffeeDto;
import com.example.entity.Coffee;
import com.example.mapper.base.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ResponseCoffeeDtoMapper extends EntityMapper<CoffeeDto, Coffee> {

    CoffeeDto toDto (Coffee coffee);

    List<CoffeeDto> toDto (List<Coffee> coffeeList);

    Coffee toEntity (CoffeeDto coffeeDto);

    List<Coffee> toEntity (List<CoffeeDto> coffeeDtoList);
}
