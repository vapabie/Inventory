package org.example.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String Name;

    @Column(name = "PRICE")
    private int Price;

    @Column(name = "QUANTITY")
    private int Quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    public Stock() {
    }

    public Stock(int id, String name, int price, int quantity) {
        this.id = id;
        Name = name;
        Price = price;
        Quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
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
        return id == stock.id && Price == stock.Price && Quantity == stock.Quantity && Objects.equals(Name, stock.Name) && Objects.equals(store, stock.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, Price, Quantity, store);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", Quantity=" + Quantity +
                ", store=" + store +
                '}';
    }
}
