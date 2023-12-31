package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.models.Product;
import com.bnta.capstone_backend.services.CustomerService;
import com.bnta.capstone_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @GetMapping("/category={category}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // filter for category

    @GetMapping("/rating={rating}")
    public ResponseEntity<List<Product>> getProductByRating(@PathVariable int rating) {
        List<Product> products = productService.getProductByRating(rating);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price/{priceLow}/{priceHigh}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable int priceLow, @PathVariable int priceHigh) {
        List<Product> products = productService.getProductByPrice(priceLow, priceHigh);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String name, @RequestParam(required = false) String category, @RequestParam(required = false) String description) {
        List<Product> products = productService.searchProducts(name,category,description);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
