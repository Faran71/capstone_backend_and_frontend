package com.bnta.capstone_backend.repositories;

import com.bnta.capstone_backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByCategory(String category);

    List<Product> findProductByRating(int rating);

    List<Product> findProductsByPrice(int price);

    List<Product> findProductsByNameOrCategoryOrDescription(String name, String category, String description);

//checkcommit
}
