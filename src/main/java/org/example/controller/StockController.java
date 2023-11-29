package org.example.controller;

import org.example.dto.StockDto;
import org.example.model.Stock;
import org.example.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    @Autowired
    StockService stockService;

    ArrayList<Stock> stocks;

    @GetMapping("/init")
    public String init(){
        stocks = new ArrayList<>();

        stocks.add(new Stock(1, "egg", 70, 720));
        stocks.add(new Stock(2, "milk", 302, 120));

        return "Success";
    }

    @GetMapping("/getstock")
    public Stock getStock(){
        Stock s = new Stock(1, "egg", 70, 720);
        return s;
    }

    @GetMapping("/getbyname/{Name}")
    public List<StockDto> getbyName(@PathVariable String Name){
        /*List<Stock> found = stocks.stream()
                .filter(x -> x.getName().equals(Name))
                .toList();

        return found;*/
        return stockService.findAllByName(Name);
    }

    @PostMapping("/addstock")
    public List<StockDto> addStock(@RequestBody StockDto stockDto){
        stockService.saveStock(stockDto);
        return stockService.findAll();
    }



}
