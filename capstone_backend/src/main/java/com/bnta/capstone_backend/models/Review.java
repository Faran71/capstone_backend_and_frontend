package com.bnta.capstone_backend.models;

public class Review {

    Long id;

    String reviewContent;

    Product product;

    public Review() {
    }

    public Review(Long id, String reviewContent, Product product) {
        this.id = id;
        this.reviewContent = reviewContent;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
