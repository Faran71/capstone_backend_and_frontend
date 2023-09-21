package com.bnta.capstone_backend.repositories;

import com.bnta.capstone_backend.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order,Long> {
}
