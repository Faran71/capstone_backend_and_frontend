package com.bnta.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="order_date_time")
    private LocalDateTime orderDateTime;


    //come back to this need clarification
    private enum Status {
        FULFILLED,
        UNFULFILLED,
        PROCESSING
    };

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties
    private List<ProductsOrders> productsOrders;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"order"})
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
