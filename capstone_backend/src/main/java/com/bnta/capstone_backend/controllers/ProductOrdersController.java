package com.bnta.capstone_backend.controllers;

import com.bnta.capstone_backend.models.ProductsOrders;
import com.bnta.capstone_backend.services.ProductsOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/productsOrders"})
public class ProductOrdersController {

    @Autowired
    ProductsOrdersService productsOrdersService;

    @GetMapping
    public ResponseEntity<List<ProductsOrders>> getAllProductsOrders() {
        return new ResponseEntity(this.productsOrdersService.findAllProductsOrders(), HttpStatus.FOUND);
    }

    @PutMapping(value = "/{productId}/{orderId}/{quantitySold}")
    public ResponseEntity<ProductsOrders> addToProdOrders(@PathVariable Long productId, @PathVariable Long orderId, @PathVariable int quantitySold){ // add order to productOrders
       ProductsOrders newProdOrder =  productsOrdersService.addToProdOrders(productId, orderId, quantitySold);
        return new ResponseEntity<>(newProdOrder, HttpStatus.CREATED);
    }
}
