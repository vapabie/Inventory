package org.example.repository;

import org.example.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    void deleteStoreById(int id);
    Optional<Store> findAllById(int id);
}
