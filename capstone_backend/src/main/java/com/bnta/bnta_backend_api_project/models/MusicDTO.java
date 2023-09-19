package com.bnta.bnta_backend_api_project.models;

public class MusicDTO {

    String creator;

    String title;

    int price;
    int cost;

    int availableQuantity;

    String decade;

    int songLength;

    public MusicDTO() {
    }

    public MusicDTO(String creator, String title, int price, int cost, int availableQuantity, String decade, int songLength) {
        this.creator = creator;
        this.title = title;
        this.price = price;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
        this.decade = decade;
        this.songLength = songLength;
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

    public String getDecade() {
        return decade;
    }

    public void setDecade(String decade) {
        this.decade = decade;
    }

    public int getSongLength() {
        return songLength;
    }

    public void setSongLength(int songLength) {
        this.songLength = songLength;
    }
}
