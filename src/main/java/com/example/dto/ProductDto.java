package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;

    /**
     * Количество товара.
     */
    private Integer count;
}
