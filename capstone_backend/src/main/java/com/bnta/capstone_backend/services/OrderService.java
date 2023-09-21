package com.bnta.capstone_backend.services;
import com.bnta.capstone_backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    // order service

    @Autowired
    OrderRepository orderRepository;


}
