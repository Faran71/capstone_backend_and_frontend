package com.bnta.capstone_backend.models;

import java.util.List;

public class Customer {

    private Long id;
    private String name;

    private String email;

    private String password;

    private String address;

    private List<Order> orders;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String address,String password, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setIg(Long id) {
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
