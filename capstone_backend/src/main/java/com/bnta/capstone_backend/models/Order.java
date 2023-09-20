package com.bnta.capstone_backend.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long id;

    private LocalDateTime orderDateTime;

    private enum Status {
        FULFILLED,
        UNFULFILLED,
        PROCESSING
    };

    private List<ProductsOrders> productsOrders;

    private Customer customer;

    public Order() {
    }

    public Order(Long id, LocalDateTime orderDateTime, List<ProductsOrders> productsOrders, Customer customer) {
        this.id = id;
        this.orderDateTime = orderDateTime;
        this.productsOrders = new ArrayList<>();
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
