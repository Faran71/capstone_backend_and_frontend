package com.bnta.capstone_backend.services;

import com.bnta.capstone_backend.repositories.ProductsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsOrdersService {

    @Autowired
    ProductsOrdersRepository productsOrdersRepository;
}
