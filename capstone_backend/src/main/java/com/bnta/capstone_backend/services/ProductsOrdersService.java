package com.bnta.capstone_backend.services;

import com.bnta.capstone_backend.models.Order;
import com.bnta.capstone_backend.models.Product;
import com.bnta.capstone_backend.models.ProductsOrders;
import com.bnta.capstone_backend.repositories.OrderRepository;
import com.bnta.capstone_backend.repositories.ProductRepository;
import com.bnta.capstone_backend.repositories.ProductsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductsOrdersService {

    @Autowired
    ProductsOrdersRepository productsOrdersRepository;

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    OrderRepository orderRepository;

    public List<ProductsOrders> findAllProductsOrders() {
        return this.productsOrdersRepository.findAll();
    }

    public ProductsOrders addToProdOrders(Long productId, Long orderId, int quantitySold){

        Product product = productRepository.findById(productId).get(); // link product to its order

        if(product.getAvailableQuantity()>=quantitySold){
            ProductsOrders newProdOrder = new ProductsOrders(); // create a new productOrder

            newProdOrder.setProduct(product); // set the product
            newProdOrder.setQuantitySold(quantitySold); // set the quantity sold

            Order order = orderRepository.findById(orderId).get(); // link order to its product
            newProdOrder.setOrder(order); //  set the order

            product.setAvailableQuantity(product.getAvailableQuantity() - quantitySold);

            productsOrdersRepository.save(newProdOrder); // save it to database
            return newProdOrder; // return the productOrder

        }
        return null;
    }
}
