package com.bnta.bnta_backend_api_project.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class BookDTO {

    String creator;

    String title;

    int price;
    int cost;

    int availableQuantity;

    int yearOfPublication;

    int noOfPages;

    public BookDTO() {
    }

    public BookDTO(String creator, String title, int price, int cost, int availableQuantity, int yearOfPublication, int noOfPages) {
        this.creator = creator;
        this.title = title;
        this.price = price;
        this.cost = cost;
        this.availableQuantity = availableQuantity;
        this.yearOfPublication = yearOfPublication;
        this.noOfPages = noOfPages;
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

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

}
