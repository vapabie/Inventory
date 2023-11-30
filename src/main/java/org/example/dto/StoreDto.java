package org.example.dto;

import java.util.Objects;

public class StoreDto {

    private int id;
    private String address;
    private String email;


    public StoreDto() {
    }

    public StoreDto(int id, String address, String email) {
        this.id = id;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDto storeDto = (StoreDto) o;
        return id == storeDto.id && Objects.equals(address, storeDto.address) && Objects.equals(email, storeDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, email);
    }

    @Override
    public String toString() {
        return "StoreDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}
