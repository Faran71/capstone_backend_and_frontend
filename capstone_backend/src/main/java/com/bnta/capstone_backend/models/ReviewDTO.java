package com.bnta.capstone_backend.models;

public class ReviewDTO {

    private String name;
    private String reviewContent;

    private Long productId;

    public ReviewDTO() {
    }

    public ReviewDTO(String name, String reviewContent, Long productId) {
        this.name = name;
        this.reviewContent = reviewContent;
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
