package com.bnta.capstone_backend.repositories;

import com.bnta.capstone_backend.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
