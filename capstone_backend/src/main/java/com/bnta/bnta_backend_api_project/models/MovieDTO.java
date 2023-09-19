package com.bnta.bnta_backend_api_project.models;

public class MovieDTO {

    String creator;

    String title;

    int price;
    int cost;

    int availableQuantity;

    double rating;

    int runTime;

    public MovieDTO() {
    }

    public MovieDTO(String creator, String title, int price, int cost, int availableQuantity, double rating, int runTime) {
        this.creator = creator;
        this.title = title;
        this.price = price;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
        this.rating = rating;
        this.runTime = runTime;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }
}
