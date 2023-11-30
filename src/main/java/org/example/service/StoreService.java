package org.example.service;

import org.example.dto.StoreDto;

import java.util.List;

public interface StoreService {

    List<StoreDto> findAll();

    StoreDto saveStore(StoreDto storeDto);

    List<StoreDto> findAllByAddress(String address);
}
