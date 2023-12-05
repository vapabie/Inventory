package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STOCK_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "QUANTITY")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    public Stock() {
    }

    public Stock(int id, String name, int price, int quantity, Store store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.store = store;
    }

    public Stock(int id, String name, int price, int quantity) {
        this.id = id;
        name = name;
        price = price;
        quantity = quantity;
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
        name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return id == stock.id && price == stock.price && quantity == stock.quantity && Objects.equals(name, stock.name) && Objects.equals(store, stock.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity, store);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                ", Quantity=" + quantity +
                ", store=" + store +
                '}';
    }
}
