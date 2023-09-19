package com.bnta.bnta_backend_api_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //example said GenerationType.AUTO, so check this if there are issues
    @Column(name = "id")
    private Long id;
    @Column(name = "order_date_time")
    LocalDateTime orderDateTime ;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"orders"})
    private Customer customer;

    @OneToMany(mappedBy = "orders")
    @JsonIgnoreProperties
    private List<ProductsOrders> productsOrders;

    public Orders() {
    }


    public Orders(LocalDateTime orderDateTime, Customer customer) {
        this.orderDateTime = orderDateTime;
        this.customer = customer;
        this.productsOrders = new ArrayList<>();
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
