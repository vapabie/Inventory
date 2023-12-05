package org.example.service.mapper;

import org.example.dto.StoreDto;
import org.example.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreDto entityToDto(Store store);

    Store dtoToEntity(StoreDto storeDto);

    List<StoreDto> entityListToDtoList(List<Store> stores);

    List<Store> dtoListToEntityList(List<StoreDto> storeDtos);
}
