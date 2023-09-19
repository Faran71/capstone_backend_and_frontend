package com.bnta.bnta_backend_api_project.services;

import com.bnta.bnta_backend_api_project.models.Customer;
import com.bnta.bnta_backend_api_project.models.Orders;
import com.bnta.bnta_backend_api_project.models.Product;
import com.bnta.bnta_backend_api_project.models.ProductsOrders;
import com.bnta.bnta_backend_api_project.repositories.CustomerRepository;
import com.bnta.bnta_backend_api_project.repositories.OrdersRepository;
import com.bnta.bnta_backend_api_project.repositories.ProductRepository;
import com.bnta.bnta_backend_api_project.repositories.ProductsOrdersRepository;
import jakarta.persistence.criteria.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    CustomerRepository customerRepository;
    
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductsOrdersRepository productsOrdersRepository;


    public List<Orders> findAllOrders() {
        return this.ordersRepository.findAll();
    }

    public List<ProductsOrders> findAllProductsOrders() {
        return this.productsOrdersRepository.findAll();
    }

    public Customer findOrder(Long id) {
        return this.customerRepository.findById(id).get();
    }

                                    //example order 1, customer 3
    public Orders addOrderToCustomer(Long customerId) {
        Orders orderToLink = new Orders(); //create a new order


        Customer customer = customerRepository.findById(customerId).get(); // link customer to its order
        orderToLink.setCustomer(customer);
        orderToLink.setOrderDateTime(LocalDateTime.now()); // time the customer will have placed the order
        ordersRepository.save(orderToLink); // save it to database
        return orderToLink;
    }

    public ProductsOrders addProductToProdOrders(Long productId, int quantitySold) {
//        ProductsOrders prodOrdersToLink = productsOrdersRepository.findById(prodOrderId).get(); //1st order // retrieves the productsOrder we want

        ProductsOrders prodOrdersToLink = new ProductsOrders();
        Product product = productRepository.findById(productId).get();
        prodOrdersToLink.setProduct(product);
        prodOrdersToLink.setQuantitySold(quantitySold);
        productsOrdersRepository.save(prodOrdersToLink); // save it to database
        return prodOrdersToLink;
    }

    public ProductsOrders addOrdersToProdOrders(Long orderId, Long productOrderId) {
        ProductsOrders prodOrdersToLink = productsOrdersRepository.findById(productOrderId).get(); //1st order // retrieves the productsOrder we want
        Orders orders = ordersRepository.findById(orderId).get(); // link customer to its order
        prodOrdersToLink.setOrders(orders);
        productsOrdersRepository.save(prodOrdersToLink); // save it to database
        return prodOrdersToLink;
    }

}
