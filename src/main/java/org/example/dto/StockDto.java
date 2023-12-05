package org.example.dto;

import org.example.model.Store;

import java.util.Objects;

public class StockDto {

    private int id;
    private String name;
    private int price;
    private int quantity;

    private StoreDto store;

    public StockDto(){

    }

    public StockDto(int id, String name, int price, int quantity, StoreDto store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.store = store;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StoreDto getStore() {
        return store;
    }

    public void setStore(StoreDto store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDto stockDto = (StockDto) o;
        return id == stockDto.id && price == stockDto.price && quantity == stockDto.quantity && Objects.equals(name, stockDto.name) && Objects.equals(store, stockDto.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, store);
    }

    @Override
    public String toString() {
        return "StockDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", store=" + store +
                '}';
    }



}
