package com.bnta.capstone_backend.models;

import java.util.List;

public class Customer {

    private Long ig;
    private String name;

    private String email;

    private String address;

    private List<Order> orders;

    public Customer() {
    }

    public Customer(Long ig, String name, String email, String address, List<Order> orders) {
        this.ig = ig;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orders = orders;
    }

    public Long getIg() {
        return ig;
    }

    public void setIg(Long ig) {
        this.ig = ig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
