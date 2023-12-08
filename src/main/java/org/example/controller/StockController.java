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
    public StockController(StockServ stockServ, StoreServ storeServ){
        this.stockServ = stockServ;
        this.storeServ = storeServ;
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

        Store store = storeServ.findStoreByid(stock.getStore().getId());
        stock.setStore(store);
        stockServ.addStock(stock);


        return "redirect:/stocks";
    }

    @GetMapping("/addstock")
    public String getAddStockForm(Model model){
        List<Store> stores = storeServ.findAllStore();
        model.addAttribute("stores", stores);
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
        Store store = storeServ.findStoreByid(stock.getStore().getId());
        stock.setStore(store);
        stockServ.updateStock(stock);
        return "redirect:/stocks";
    }

    @GetMapping("/updatestock/{id}")
    public String getUpdateStockForm(@PathVariable Integer id, Model model) {
        Stock stock = stockServ.findStockById(id);
        List<Store> stores = storeServ.findAllStore();
        model.addAttribute("stores", stores);
        model.addAttribute("updatedStock", stock);

        return "updatestock";
    }
/*
    @DeleteMapping("/deletestock/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable Integer id) {
        try {
            stockServ.deleteStock(id);
            return new ResponseEntity<>("Stock deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting stock: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    @PostMapping("/deletestock/{id}")
    public String deleteStockConfirmation(@PathVariable Integer id) {
        stockServ.deleteStock(id);
        return "redirect:/stocks";
    }

    @GetMapping("/deletestock/{id}")
    public String getDeleteStockConfirmation(@PathVariable Integer id, Model model) {
        Stock stock = stockServ.findStockById(id);
        model.addAttribute("stock", stock);
        return "deletestock";
    }

}
