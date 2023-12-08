package org.example.repository;

import org.example.model.Stock;
import org.example.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    void deleteStockById(int id);

    Optional<Stock> findById(int id);


    Optional<Stock> findAllById(int id);
}
