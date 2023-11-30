package org.example.service;

import org.example.dto.StockDto;
import org.example.dto.StoreDto;

import java.util.List;

public interface StoreService {

    List<StoreDto> findAll();

    StoreDto findById(Integer id);

    StoreDto saveStore(StoreDto storeDto);

    List<StoreDto> findAllByCity(String city);
}
