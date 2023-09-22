package com.bnta.capstone_backend.services;
import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.models.Order;
import com.bnta.capstone_backend.models.Product;
import com.bnta.capstone_backend.models.ProductsOrders;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import com.bnta.capstone_backend.repositories.OrderRepository;
import com.bnta.capstone_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {
    // order service

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;


    public Order createOrder(Long customerId) {
        Order newOrder = new Order(); //create a new order
        Customer customer = customerRepository.findById(customerId).get(); // link customer to its order
        newOrder.setCustomer(customer); // set the customer
        newOrder.setOrderDateTime(LocalDateTime.now()); // time the customer will have placed the order
        orderRepository.save(newOrder);
        return newOrder; // return the order
    }

}
