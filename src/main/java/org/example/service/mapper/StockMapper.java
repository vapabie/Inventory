package org.example.service.mapper;

import org.example.dto.StockDto;
import org.example.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDto entityToDto(Stock stock);

    Stock dtoToEntity(StockDto stockDto);

    List<StockDto> entityListtoDtoList(List<Stock> stocks);

    List<Stock> dtoListToEntityList(List<StockDto> stockDtos);

}