package org.example.controller;

import org.example.dto.StockDto;
import org.example.dto.StoreDto;
import org.example.model.Store;
import org.example.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    StoreService storeService;

    ArrayList<Store> stores;

    @GetMapping("/init")
    public String init(){
        stores = new ArrayList<>();

        stores.add(new Store(1, "Debrecen",  "x ut 9", "debi@store.com"));
        stores.add(new Store(2, "Debrecen" ,"z ut 24", "debi@store.com"));
        stores.add(new Store(3, "Nyiregyháza" ,"t ut 31", "nyiregy@store.com"));

        return "Success";
    }


    @GetMapping("/getstore")
    public Store getStore(){
        Store s = new Store(1, "Debrecen" ,"x ut 9", "debi@store.com");
        return s;
    }

    @GetMapping("/getbycity/{city}")
    public List<StoreDto> getByCity(@PathVariable String city){
        return storeService.findAllByCity(city);
    }

    @PostMapping("/addstore")
    public List<StoreDto> addStore(@RequestBody StoreDto storeDto){
        storeService.saveStore(storeDto);
        return storeService.findAll();
    }

}
