package org.example.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Objects;

@Entity
@Table(name = "STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ADDRESS")
    private String Author;

    @Column(name = "EMAIL")
    private String Email;

    public Store() {
    }

    public Store(int id, String author, String email) {
        this.id = id;
        Author = author;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && Objects.equals(Author, store.Author) && Objects.equals(Email, store.Email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Author, Email);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", Author='" + Author + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }





}
