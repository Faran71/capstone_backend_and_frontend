package com.bnta.bnta_backend_api_project.services;

import com.bnta.bnta_backend_api_project.controllers.CustomerController;
import com.bnta.bnta_backend_api_project.models.Customer;
import com.bnta.bnta_backend_api_project.models.CustomerDTO;
import com.bnta.bnta_backend_api_project.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    public Customer findCustomer(Long id) {
        return this.customerRepository.findById(id).get();
    }

    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer1 = new Customer(customerDTO.getName(), customerDTO.getEmail(), customerDTO.getCardNumber());
        return this.customerRepository.save(customer1);
    }

    public Customer updateCustomer(CustomerDTO customerDTO, Long id) {
        Customer customerToUpdate = customerRepository.findById(id).get();
        customerToUpdate.setName(customerDTO.getName());
        customerToUpdate.setEmail(customerDTO.getEmail());

        //  beginner index is the total length - 4 so that we only get the last 4 digits of any card length as beginning index would start at 4th character before the last

        String cardNumber= customerDTO.getCardNumber();
        String lastFourDigitsCN = cardNumber.substring(cardNumber.length() - 4);
        customerToUpdate.setCardNumber(lastFourDigitsCN);   //  sets the last 4 digits of card number

        customerRepository.save(customerToUpdate);
        return customerToUpdate;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
