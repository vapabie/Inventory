package org.example.controller;


import org.example.model.Stock;
import org.example.model.Store;

import org.example.service.StockServ;
import org.example.service.StoreServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class StockController {

    private StockServ stockServ;

    private StoreServ storeServ;

    @Autowired
    public StockController(StockServ stockServ){
        this.stockServ = stockServ;
    }
    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks = stockServ.findAllStore();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @PostMapping("/addstock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock){

        Stock stock1 = stockServ.addStock(stock);
        return new ResponseEntity<>(stock1, HttpStatus.OK);
    }

    @PutMapping("/updatestock")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        Stock updateStock = stockServ.updateStock(stock);

        return new ResponseEntity<>(updateStock, HttpStatus.OK);
    }

    @DeleteMapping("/deletestock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Integer id) {
        try {
            stockServ.deleteStock(id);
            return new ResponseEntity<>("Stock deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting stock: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
