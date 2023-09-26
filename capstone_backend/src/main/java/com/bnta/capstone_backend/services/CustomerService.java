package com.bnta.capstone_backend.services;
import com.bnta.capstone_backend.authentication.LoginForm;
import com.bnta.capstone_backend.models.Customer;
import com.bnta.capstone_backend.models.CustomerDTO;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.List;

@Service
public class CustomerService {
    // customer service

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer addCustomer(CustomerDTO customerDTO) {
        String encryptPassword = passwordEncoder.encode(customerDTO.getPassword());
        Customer customer = new Customer(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getAddress(), encryptPassword);
        return this.customerRepository.save(customer);
    }

    public Customer checkCredentials(String email, String password){
        // find the customer by email
        Customer customer = customerRepository.findByEmail(email);
        // check if the passwords match using encoder
        if (customer != null && passwordEncoder.matches(password,customer.getPassword())){
            return customer;
        }
        // return the customer if it does otherwise dont return anything
        return null;
    }




}
