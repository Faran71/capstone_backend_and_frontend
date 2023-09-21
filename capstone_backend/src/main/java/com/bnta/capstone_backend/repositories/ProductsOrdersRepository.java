package com.bnta.capstone_backend.repositories;

import com.bnta.capstone_backend.models.ProductsOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOrdersRepository extends JpaRepository<ProductsOrders, Long> {
}
