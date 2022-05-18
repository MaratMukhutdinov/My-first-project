package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoffeeDto {

    /**
     * id товара.
     */
    private Long id;

    /**
     * Наименование кофе.
     */
    @NotEmpty
    private String name;

    /**
     * Остаток кофе в мл.
     */
    @NotNull
    private Long balance;
}
