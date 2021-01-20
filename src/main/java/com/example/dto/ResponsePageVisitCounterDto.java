package com.example.dto;

import lombok.Data;

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
