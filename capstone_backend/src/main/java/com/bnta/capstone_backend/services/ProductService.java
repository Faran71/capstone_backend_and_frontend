package com.bnta.capstone_backend.services;

import com.bnta.capstone_backend.models.Product;
import com.bnta.capstone_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.findProductsByCategory(category);
    }

    // filter get product by rating
    public List<Product> getProductByRating(int rating){
        return productRepository.findProductByRating(rating);
    }

    // filter get product by price
    public List<Product> getProductByPrice(int price){
        return productRepository.findProductsByPrice(price);
    }

    // search bar
    public List<Product> searchProducts(String name, String category,String description ) {
        return productRepository.searchProductsByFilters(name,category,description);
    }


}
