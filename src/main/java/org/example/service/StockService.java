package org.example.service;

import org.example.dto.StockDto;
import org.example.model.Stock;

import java.util.List;

public interface StockService {

    List<StockDto> findAll();

    StockDto findbyId(Integer id);

    StockDto saveStock(StockDto stockDto);

    List<StockDto> findAllByName(String name);



}
