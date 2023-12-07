package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Stock;
import org.example.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockServ {

    private StockRepository stockRepository;

    @Autowired
    public StockServ(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock addStock(Stock stock){
        return stockRepository.save(stock);
    }

    public List<Stock> findAllStore(){
        return stockRepository.findAll();
    }

    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }

    public void deleteStock(int id){
        stockRepository.deleteStockById(id);
    }
}
