package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.services.ProductsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/productsOrders"})
public class ProductOrdersController {

    @Autowired
    ProductsOrdersService productsOrdersService;




}
