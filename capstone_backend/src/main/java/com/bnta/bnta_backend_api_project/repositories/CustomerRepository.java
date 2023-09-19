package com.bnta.bnta_backend_api_project.repositories;

import com.bnta.bnta_backend_api_project.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
