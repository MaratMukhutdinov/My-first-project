package com.example.service.impl;

import com.example.dto.ResponsePageVisitCounterDto;
import com.example.mapper.ResponsePageVisitCounterMapper;
import com.example.model.PageVisitCounter;
import com.example.repository.PageVisitCounterRepository;
import com.example.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CounterServiceImpl implements CounterService {

    private final PageVisitCounterRepository pageVisitCounterRepository;

    private final ResponsePageVisitCounterMapper pageVisitDtoMapper;

    @Override
    public List<ResponsePageVisitCounterDto> countVisits() {
        List<PageVisitCounter> page = pageVisitCounterRepository.findAll();
        return pageVisitDtoMapper.toDto(page);
    }
}
