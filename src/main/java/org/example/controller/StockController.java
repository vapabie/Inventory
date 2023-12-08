package org.example.controller;


import org.example.model.Stock;
import org.example.model.Store;

import org.example.service.StockServ;
import org.example.service.StoreServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class StockController {

    private StockServ stockServ;

    private StoreServ storeServ;

    @Autowired
    public StockController(StockServ stockServ){
        this.stockServ = stockServ;
    }
    /*
    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStock(){
        List<Stock> stocks = stockServ.findAllStore();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
     */

    @GetMapping("stocks")
    public String getAllStocks(Model model) {
        List<Stock> stocks = stockServ.findAllStocks();
        model.addAttribute("stocks", stocks);
        return "stocks";
    }
/*
    @PostMapping("/addstock")
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock ){
        stockServ.addStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }
*/
    @PostMapping("/addstock")
    public String addStock(@ModelAttribute("newStock") Stock stock) {
        // Save the store to the database
        stockServ.addStock(stock);

        // Redirect to the stocks screen
        return "redirect:/stocks";
    }

    @GetMapping("/addstock")
    public String getAddStockForm(Model model){
        model.addAttribute("newStock", new Stock());
        return "addstock";
    }
/*
    @PutMapping("/updatestock")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
        Stock updateStock = stockServ.updateStock(stock);

        return new ResponseEntity<>(updateStock, HttpStatus.OK);
    }
    */

    @PostMapping("/updatestock/{id}")
    public String updateStock(@PathVariable Integer id, @ModelAttribute("updatedStock") Stock stock){
        stockServ.updateStock(stock);
        return "redirect:/stocks";
    }

    @GetMapping("/updatestock/{id}")
    public String getUpdateStockForm(@PathVariable Integer id, Model model) {
        Stock stock = stockServ.findStockById(id);

        model.addAttribute("updatedStock", stock);

        return "updatestock";
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
