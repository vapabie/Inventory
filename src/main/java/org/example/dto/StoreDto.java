package org.example.dto;

import java.util.Objects;

public class StoreDto {

    private int id;

    private String city;
    private String address;
    private String email;

    public StoreDto() {
    }

    public StoreDto(int id, String city, String address, String email) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        return id == storeDto.id && Objects.equals(city, storeDto.city) && Objects.equals(address, storeDto.address) && Objects.equals(email, storeDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, address, email);
    }


    @Override
    public String toString() {
        return "StoreDto{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
