package org.example.service.impl;

import org.example.dto.StoreDto;
import org.example.model.Store;
import org.example.repository.StoreRepository;
import org.example.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    @Override
    public List<StoreDto> findAll() {
        List<Store> entities = storeRepository.findAll();
        List<StoreDto> dtos = new ArrayList<>();

        for(Store s: entities){
            dtos.add(new StoreDto(s.getId(),s.getCity(), s.getAddress(),s.getEmail()));
        }

        return dtos;
    }

    @Override
    public StoreDto findById(Integer id) {
        Store entity = storeRepository.getReferenceById(id);

        return new StoreDto(entity.getId(), entity.getCity(), entity.getAddress(), entity.getEmail());
    }

    @Override
    public StoreDto saveStore(StoreDto storeDto) {
        Store entity = new Store(storeDto.getId(), storeDto.getCity(), storeDto.getAddress(), storeDto.getEmail());

        return new StoreDto(entity.getId(), entity.getCity(), entity.getAddress(), entity.getEmail());

    }

    @Override
    public List<StoreDto> findAllByCity(String city) {
        List<Store> entities = storeRepository.findAllByCityEqualsIgnoreCase(city);
        List<StoreDto> dtos = new ArrayList<>();

        for (Store s : entities){
            dtos.add(new StoreDto(s.getId(),s.getCity(),s.getAddress(),s.getEmail()));
        }

        return dtos;
    }
}
