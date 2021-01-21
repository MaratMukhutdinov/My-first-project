package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponsePageVisitCounterDto {

    /**
     * Название страницы.
     */
    private String pageName;

    /**
     * Счетчик посещения страницы.
     */
    private Long counter;
}
