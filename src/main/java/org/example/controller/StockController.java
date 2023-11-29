package org.example.controller;

import org.example.model.Stock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StockController {

    ArrayList<Stock> stocks;

    @GetMapping("/init")
    public String init(){
        stocks = new ArrayList<>();

        stocks.add(new Stock(1, "egg", 70, 720));

        return "Success";
    }

    @GetMapping("/getstock")
    public Stock getStock(){
        Stock s = new Stock(1, "egg", 70, 720);
        return s;
    }

    @GetMapping("/getbyname/{Name}")
    public List<Stock> getbyName(@PathVariable String Name){
        List<Stock> found = stocks.stream()
                .filter(x -> x.getName().equals(Name))
                .toList();

        return found;
    }




}
