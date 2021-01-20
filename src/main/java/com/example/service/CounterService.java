package com.example.service;

import com.example.dto.ResponsePageVisitCounterDto;

import java.util.List;

public interface CounterService {

    List<ResponsePageVisitCounterDto> countVisits();
}