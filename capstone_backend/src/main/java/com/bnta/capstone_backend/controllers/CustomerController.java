package com.bnta.capstone_backend.controllers;


import com.bnta.capstone_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {

    @Autowired // this is called depedancy injection
    CustomerService customerService;

}
