package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    /**
     * id товара.
     */
    private Long id;

    /**
     * Название товара.
     */
    @NotEmpty
    private String name;

    /**
     * Количество товара.
     */
    @Digits(integer = 2, fraction = 0)
    @NotNull
    private Integer count;
}
