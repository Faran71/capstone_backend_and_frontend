package com.bnta.bnta_backend_api_project.controllers;

import com.bnta.bnta_backend_api_project.models.Customer;
import com.bnta.bnta_backend_api_project.models.CustomerDTO;
import com.bnta.bnta_backend_api_project.models.Orders;
import com.bnta.bnta_backend_api_project.services.CustomerService;
import com.bnta.bnta_backend_api_project.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    OrdersService ordersService;

    //    INDEX
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity(this.customerService.findAllCustomers(), HttpStatus.FOUND);
    }

    //    SHOW
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerService.findCustomer(id), HttpStatus.FOUND);
    }

    //    CREATE
    @PostMapping
    public ResponseEntity<Customer> postCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return new ResponseEntity(customerService.findAllCustomers(), HttpStatus.CREATED);
    }

    //    UPDATE
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id) {
        Customer updateCustomer = customerService.updateCustomer(customerDTO, id);
        return new ResponseEntity(updateCustomer, HttpStatus.OK);
    }

    //    DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //  Add Order
    @PutMapping(value = "addOrder/{customerId}")
    public ResponseEntity<Orders> addCustomerToOrder(@PathVariable Long customerId){
      Orders linkedOrder =  ordersService.addOrderToCustomer(customerId);
        return new ResponseEntity<>(linkedOrder, HttpStatus.CREATED);
    }


}
