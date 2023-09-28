package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.models.CustomerDTO;
import com.bnta.capstone_backend.models.Review;
import com.bnta.capstone_backend.models.ReviewDTO;
import com.bnta.capstone_backend.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/reviews"})
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> postReview(@RequestBody ReviewDTO reviewDTO){
        reviewService.addReview(reviewDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}