package com.bnta.capstone_backend.controllers;


import com.bnta.capstone_backend.authentication.CustomerSecurityConfiguration;
import com.bnta.capstone_backend.authentication.LoginForm;
import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.models.CustomerDTO;
import com.bnta.capstone_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Customer> postCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return new ResponseEntity(customerService.findAllCustomers(), HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Customer> authenticateCustomer(@RequestBody LoginForm loginForm) {
        Customer checkCustomer = customerService.checkCredentials(loginForm.getEmail(),loginForm.getPassword());
        return checkCustomer != null ? new ResponseEntity<>(checkCustomer,HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
