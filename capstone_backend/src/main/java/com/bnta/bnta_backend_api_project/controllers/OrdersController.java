package com.bnta.bnta_backend_api_project.controllers;

import com.bnta.bnta_backend_api_project.models.Customer;
import com.bnta.bnta_backend_api_project.models.Orders;
import com.bnta.bnta_backend_api_project.models.ProductsOrders;
import com.bnta.bnta_backend_api_project.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/orders"})
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping()
    public ResponseEntity<List<Orders>> getAllOrders() {
        return new ResponseEntity(this.ordersService.findAllOrders(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Customer>> getOrder(@PathVariable Long id) {
        return new ResponseEntity(ordersService.findOrder(id), HttpStatus.FOUND);
    }

    //  Add Product to ProductOrders
    @PutMapping(value = "linkProdOrders/{productsId}/{quantitySold}")
    public ResponseEntity<ProductsOrders> addProdToProdOrders(@PathVariable Long productsId, @PathVariable int quantitySold){
        ProductsOrders linkedProdOrderToProd =  ordersService.addProductToProdOrders(productsId, quantitySold);
        return new ResponseEntity<>(linkedProdOrderToProd, HttpStatus.CREATED);
    }

    @PutMapping(value = "linkOrderProdOrder/{ordersId}/{productsId}")
    public ResponseEntity<ProductsOrders> addOrdersToProdOrders(@PathVariable Long ordersId, @PathVariable Long productsId){
        ProductsOrders linkedProdOrdertoOrder =  ordersService.addOrdersToProdOrders(ordersId, productsId);
        return new ResponseEntity<>(linkedProdOrdertoOrder, HttpStatus.CREATED);
    }

}
