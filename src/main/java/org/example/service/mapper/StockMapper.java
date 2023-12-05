package org.example.service.mapper;

import org.example.dto.StockDto;
import org.example.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StoreMapper.class})
public interface StockMapper {

    @Mapping(target = "store", source = "store") // use the property name directly
    StockDto entityToDto(Stock stock);

    @Mapping(target = "store", source = "store") // use the property name directly
    Stock dtoToEntity(StockDto stockDto);

    List<StockDto> entityListtoDtoList(List<Stock> stocks);

    List<Stock> dtoListToEntityList(List<StockDto> stockDtos);

}