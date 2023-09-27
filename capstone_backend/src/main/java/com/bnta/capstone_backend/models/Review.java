package com.bnta.capstone_backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Review {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column

    private String userName;
    private String reviewContent;

    private Product product;

    public Review() {
    }

    public Review( String reviewContent, Product product) {
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
