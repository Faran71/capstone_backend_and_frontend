package com.bnta.capstone_backend.services;

import com.bnta.capstone_backend.models.*;
import com.bnta.capstone_backend.repositories.ProductRepository;
import com.bnta.capstone_backend.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ReviewRepository reviewRepository;

// GET product by ID
//    Create method that takes in customer name, review msg and product id from DTO
//    method will retrieve product  by its id from the frontend
//    save to the review table


    public Review addReview(ReviewDTO reviewDTO){
        Product getProduct = productRepository.findById(reviewDTO.getProductId()).get();
        Review review = new Review(reviewDTO.getName(), reviewDTO.getReviewContent(), getProduct);
        return this.reviewRepository.save(review);
    }
}
