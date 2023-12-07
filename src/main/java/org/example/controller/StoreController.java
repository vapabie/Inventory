package org.example.controller;


import org.example.model.Store;
import org.example.service.StoreServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class StoreController {


    private final StoreServ storeServ;


    @Autowired
    public StoreController(StoreServ storeServ){
        this.storeServ = storeServ;
    }

    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> stores = storeServ.findAllStore();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @PostMapping("/addstore")
    public ResponseEntity<Store> addStore(@RequestBody Store store){
        Store newStore = storeServ.addStore(store);
        return new ResponseEntity<>(newStore, HttpStatus.OK);
    }

    @PutMapping("/updatestore")
    public ResponseEntity<Store> updateStore(@RequestBody Store store){
        Store updateStore = storeServ.updateStore(store);
        return new ResponseEntity<>(updateStore, HttpStatus.OK);
    }

    @DeleteMapping("/deletestore/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable("id") int id){
        storeServ.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
