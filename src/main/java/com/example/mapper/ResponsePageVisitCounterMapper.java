package com.example.mapper;

import com.example.dto.ResponsePageVisitCounterDto;
import com.example.mapper.base.EntityMapper;
import com.example.model.PageVisitCounter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ResponsePageVisitCounterMapper extends EntityMapper<ResponsePageVisitCounterDto, PageVisitCounter> {

    ResponsePageVisitCounterDto toDto(PageVisitCounter pageVisitCounter);

    List<ResponsePageVisitCounterDto> toDto(List<PageVisitCounter> pageVisitCounter);
}
