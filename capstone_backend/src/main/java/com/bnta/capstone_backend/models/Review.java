package com.bnta.capstone_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;
    @Column
    private String reviewContent;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonIgnoreProperties({"review"})
    private Product product;

    public Review() {
    }

    public Review( String name, String reviewContent, Product product) {
        this.name = name;
        this.reviewContent = reviewContent;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
