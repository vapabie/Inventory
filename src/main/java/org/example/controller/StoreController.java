package org.example.controller;


import org.example.model.Stock;
import org.example.model.Store;
import org.example.service.StoreServ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("")
public class StoreController {


    private final StoreServ storeServ;


    @Autowired
    public StoreController(StoreServ storeServ){
        this.storeServ = storeServ;
    }
/*
    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> stores = storeServ.findAllStore();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    */

    @GetMapping("stores")
    public String getAllStores(Model model) {
        List<Store> stores = storeServ.findAllStore();
        model.addAttribute("stores", stores);
        return "stores";
    }

/*
    @PostMapping("/addstore")
    public ResponseEntity<Store> addStore(@RequestBody Store store){
        Store newStore = storeServ.addStore(store);
        return new ResponseEntity<>(newStore, HttpStatus.OK);
    }
*/

    @PostMapping("/addstore")
    public String addStore(@ModelAttribute("newStore") Store store) {
        // Save the store to the database
        storeServ.addStore(store);

        // Redirect to the stocks screen
        return "redirect:/stores";
    }

    @GetMapping("/addstore")
    public String getAddStoreForm(Model model) {
        model.addAttribute("newStore", new Store());

        return "addstore";
    }

/*
    @PutMapping("/updatestore")
    public ResponseEntity<Store> updateStore(@RequestBody Store store){
        Store updateStore = storeServ.updateStore(store);
        return new ResponseEntity<>(updateStore, HttpStatus.OK);
    }
*/

    @PostMapping("/updatestore/{id}")
    public String updateStock(@PathVariable Integer id, @ModelAttribute("updatedStock") Store store){
        storeServ.updateStore(store);
        return "redirect:/stores";
    }

    @GetMapping("/updatestore/{id}")
    public String getUpdateStoreForm(@PathVariable Integer id, Model model) {
        Store store = storeServ.findStoreByid(id);

        model.addAttribute("updatedStore", store);

        return "updatestore";
    }
    /*
    @DeleteMapping("/deletestore/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable("id") int id){
        storeServ.deleteStore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

     */
    @PostMapping("/deletestore/{id}")
    public String deleteStoreConfirmation(@PathVariable Integer id) {
        storeServ.deleteStore(id);
        return "redirect:/stores";
    }

    @GetMapping("/deletestore/{id}")
    public String getDeleteStoreConfirmation(@PathVariable Integer id, Model model) {
        Store store = storeServ.findStoreByid(id);
        model.addAttribute("store", store);
        return "deletestore";
    }

}
