package com.example.controller;

import com.example.dto.ResponsePageVisitCounterDto;
import com.example.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GreetingController {

    private final CounterService counterService;

    @GetMapping("/visit-counter")
    public List<ResponsePageVisitCounterDto> pageVisitCounter() {
        return counterService.countVisits();
    }
}
