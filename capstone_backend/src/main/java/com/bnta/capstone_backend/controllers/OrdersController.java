package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/orders"})
public class OrdersController {

    @Autowired
    OrderService orderService;


}
