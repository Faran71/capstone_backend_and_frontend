package com.bnta.capstone_backend.controllers;


import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {

    @Autowired // this is called dependency injection
    CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity(this.customerService.findAllCustomers(), HttpStatus.FOUND);
    }

}
