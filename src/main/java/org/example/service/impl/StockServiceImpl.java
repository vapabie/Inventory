package org.example.service.impl;

import org.example.dto.StockDto;
import org.example.model.Stock;
import org.example.repository.StockRepository;
import org.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Override
    public List<StockDto> findAll(){
        List<Stock> entities = stockRepository.findAll();
        List<StockDto> dtos = new ArrayList<>();

        for( Stock s : entities){
            dtos.add(new StockDto(s.getId(), s.getName(), s.getPrice(), s.getQuantity()));

        }

        return dtos;
    }

    @Override
    public StockDto findById(Integer id){
        Stock entity = stockRepository.getReferenceById(id);

        return new StockDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getQuantity());

    }

    @Override
    public StockDto saveStock(StockDto stockDto){
        Stock entity = new Stock(stockDto.getId(), stockDto.getName(), stockDto.getPrice(), stockDto.getQuantity());

        return new StockDto((entity.getId()), entity.getName(),entity.getPrice(), entity.getQuantity());

    }

    @Override
    public List<StockDto> findAllByName(String name){
        List<Stock> entities = stockRepository.findAllByNameEqualsIgnoreCase(name);
        List<StockDto> dtos = new ArrayList<>();

        for(Stock s: entities){
            dtos.add(new StockDto(s.getId(),s.getName(),s.getPrice(),s.getQuantity()));
        }
        return  dtos;
    }
}
