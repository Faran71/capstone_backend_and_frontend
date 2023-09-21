package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.services.CustomerService;
import com.bnta.capstone_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    ProductService productService;



}
