package com.bnta.capstone_backend.repositories;

import com.bnta.capstone_backend.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByCategory(String category);

    List<Product> findProductByRating(int rating);

    List<Product> findProductsByPriceBetween(int priceLow, int priceHigh);

    @Query("SELECT p FROM Product p "
        + "WHERE (:name IS NULL OR p.name ILIKE CONCAT ('%', :name, '%'))"
        + "AND (:category IS NULL OR p.category ILIKE CONCAT('%', :category, '%'))"
        + "AND (:description IS NULL OR p.description ILIKE CONCAT('%', :description, '%'))"
    )


    List<Product> searchProductsByFilters(
            @Param("name") String name,
            @Param("category") String category,
            @Param("description") String description
    );
}
