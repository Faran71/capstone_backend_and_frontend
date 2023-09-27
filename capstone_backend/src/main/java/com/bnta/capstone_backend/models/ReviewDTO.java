package com.bnta.capstone_backend.models;

public class ReviewDTO {

    private String name;
    private String reviewContent;

    public ReviewDTO() {
    }

    public ReviewDTO(String userName, String reviewContent) {
        this.name = name;
        this.reviewContent = reviewContent;
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = name;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}
