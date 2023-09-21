package com.bnta.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class ProductsOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //example said GenerationType.AUTO, so check this if there are issues
    @Column(name = "id")
    private Long id;

    @Column
    private int quantitySold;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"products_orders"})
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    @JsonIgnoreProperties({"products_orders"})
    private Order order;

    public ProductsOrders() {
    }

    public ProductsOrders(Long id, int quantitySold, Product product, Order order) {
        this.id = id;
        this.quantitySold = quantitySold;
        this.product = product;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
