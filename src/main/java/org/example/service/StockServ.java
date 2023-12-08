package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Stock;
import org.example.model.Store;
import org.example.repository.StockRepository;
import org.example.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StockServ {

    private StockRepository stockRepository;

    private StoreRepository storeRepository;

    @Autowired
    public StockServ(StockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    public Stock addStock(Stock stock){
        return stockRepository.save(stock);
    }

    public List<Stock> findAllStocks(){
        return stockRepository.findAll();
    }

    public Stock findStockById(int id) {
        return stockRepository.findById(id)
                .orElse(null); // You can customize the behavior when the stock is not found
    }

    public Stock updateStock(Stock stock){
        return stockRepository.save(stock);
    }

    public void deleteStock(int id){
        stockRepository.deleteStockById(id);
    }
}
