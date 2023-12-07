package org.example.service;

import jakarta.transaction.Transactional;
import org.example.model.Store;
import org.example.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StoreServ {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreServ(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    public Store addStore(Store store){
        return storeRepository.save(store);
    }

    public Store findStoreByid(int id){
        return storeRepository.findById(id)
                .orElse(null);
    }

    public List<Store> findAllStore(){
        return storeRepository.findAll();
    }

    public Store updateStore(Store store){
        return storeRepository.save(store);
    }

    public void deleteStore(int id){
        storeRepository.deleteStoreById(id);
    }

}
