package com.bnta.capstone_backend.models;

public class ReviewDTO {

    private String userName;
    private String reviewContent;

    public ReviewDTO() {
    }

    public ReviewDTO(String userName, String reviewContent) {
        this.userName = userName;
        this.reviewContent = reviewContent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }
}
