package com.bnta.bnta_backend_api_project.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "media_type")
public abstract class Product { // need to add entity annotations column and the super mapper
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //example said GenerationType.AUTO, so check this if there are issues
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;
    @Column
    protected String creator;
    @Column
    protected String title;
    @Column
    protected int price; // should we turn them to ints so (pennies) to avoid division rounding errors?
    @Column
    protected int cost; // should we turn them to ints so (pennies) to avoid division rounding errors?
    @Column(name = "available_quantity")
    protected int availableQuantity;

    @Column
    protected String image;

    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties({"product"})
    private List<ProductsOrders> productOrders;

    public Product() {

    }

    public Product(String creator, String title, int price, int cost, int availableQuantity, String image) {
        this.creator = creator;
        this.title = title;
        this.price = price;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
        this.productOrders = new ArrayList<>();
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductsOrders> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductsOrders> productOrders) {
        this.productOrders = productOrders;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public
    String getImage(){
        return image;
    }

    public
    void setImage(String image){
        this.image = image;
    }
}
