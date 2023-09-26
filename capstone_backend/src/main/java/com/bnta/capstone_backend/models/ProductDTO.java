package com.bnta.capstone_backend.models;

import jakarta.persistence.Column;

public class ProductDTO {

    private String name; // search menu


    private int price;

    private int availableQuantity;

    private String imageURL;

    private String category; // filter by this have a filter for each category

    private String item;

    private String description;

    private int rating;

    public ProductDTO() {
    }

    public ProductDTO(String name, int price, int availableQuantity, String imageURL, String category, String item, String description, int rating) {
        this.name = name;
        this.price = price;
        this.availableQuantity = availableQuantity;
        this.imageURL = imageURL;
        this.category = category;
        this.item = item;
        this.description = description;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
