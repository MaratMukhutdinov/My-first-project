package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCoffeeCountChangeDto {

    /**
     * id добавляемого кофе
     */
    @NotNull
    private Long coffeeId;

    /**
     * Количество в мг.
     */
    @NotNull
    private Long count;
}
