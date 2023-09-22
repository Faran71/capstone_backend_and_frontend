package com.bnta.capstone_backend.services;
import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    // customer service

    @Autowired
    CustomerRepository customerRepository;


    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }
}
