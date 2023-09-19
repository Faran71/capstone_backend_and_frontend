package com.bnta.bnta_backend_api_project.controllers;

import com.bnta.bnta_backend_api_project.models.Orders;
import com.bnta.bnta_backend_api_project.models.ProductsOrders;
import com.bnta.bnta_backend_api_project.repositories.ProductsOrdersRepository;
import com.bnta.bnta_backend_api_project.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping({"/productsOrders"})
public class ProductsOrdersController {


    @Autowired
    OrdersService ordersService;
    @GetMapping
    public ResponseEntity<List<ProductsOrders>> getAllProductsOrders() {
        return new ResponseEntity(this.ordersService.findAllProductsOrders(), HttpStatus.FOUND);
    }

}
