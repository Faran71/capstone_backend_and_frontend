package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.models.Order;
import com.bnta.capstone_backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/orders"})
public class OrdersController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "createOrder/{customerId}")
    public ResponseEntity<Order> addCustomerToOrder(@PathVariable Long customerId){
        Order createOrder =  orderService.createOrder(customerId);
        return new ResponseEntity<>(createOrder, HttpStatus.CREATED);
    }

}
