package com.bnta.capstone_backend.models;

public class ProductsOrders {

    private Long id;

    private int quantitySold;

    private Product product;

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
