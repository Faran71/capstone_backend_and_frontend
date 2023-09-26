package com.bnta.capstone_backend.components;

import com.bnta.capstone_backend.models.*;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import com.bnta.capstone_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // CUSTOMER DATA LOADER

        List<Customer> customers = Arrays.asList(
                new Customer("Jannah", "kittybrownietwirl@outlook.com", "35 Hungry Road, Hungary", "12345" ));


        for (Customer customer : customers) {
            String encryptPassword = passwordEncoder.encode(customer.getPassword()); // hash password for security
            Customer customerName = new Customer(customer.getName(), customer.getEmail(), customer.getAddress(), encryptPassword);
            customerRepository.save(customerName);
        }

        // PRODUCTS DATA LOADER

        List<Product> products = Arrays.asList(
                new Product("Kiikii t-shirt",
                        100,
                        20,
                        "https://images.unsplash.com/photo-1576566588028-4147f3842f27?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1664&q=80",
                        "Clothes",
                        "T-Shirt",
                        "Unisex plain white t-Shirt with a printed cat drawn on a canvas that's blue",
                        3),

                new Product("Beige Sweatshirt",
                        25,
                        40,
                        "https://images.unsplash.com/photo-1644263701566-f99003bcba2d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1266&q=80",
                        "Clothes",
                        "Sweatshirt",
                        "Unisex light beige sweatshirt with small image detailing on center of chest, oversized relaxed fit",
                        3),


                new Product("Maroon GAP trouser",
                        30,
                        50,
                        "https://images.unsplash.com/photo-1638394440667-aa54a7c0a703?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
                        "Clothes",
                        "Trousers",
                        "Mens maroon corduroy wide leg trousers, straight leg with a regular fit, up to ankles",
                        5),

                new Product("Black Zara leather jacket",
                        50,
                        50,
                        "https://images.unsplash.com/photo-1551028719-00167b16eac5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1035&q=80",
                        "Clothes",
                        "Leather Jacket",
                        "Black fitted leather jacket with silver hardware",
                        3),

                new Product("Hoka Running shoes",
                        300,
                        5,
                        "https://images.unsplash.com/photo-1676767720609-c76265fb3074?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1227&q=80",
                        "Clothes",
                        "Shoes",
                        "The only running shoes you will ever need, steamlined, shock absorption, limited edition",
                        5),

                new Product("Green maxi-dress",
                        35,
                        40,
                        "https://images.unsplash.com/photo-1609695813802-3c443be34359?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2832&q=80",
                        "Clothes",
                        "Maxi-dress",
                        "Full length warm green maxi dress to get you ready for a day in Italy, sleeveless with V neck and A line bottom",
                        2),



                new Product("BNTA Macbook Pro",
                        1200,
                        5,
                        "https://images.unsplash.com/photo-1542393545-10f5cde2c810?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1665&q=80",
                        "Electronics",
                        "Free Macbook",
                        "BNTA I'm only going to do the hackathon to keep your laptop and in 2 weeks my dog will break it 😉",
                        3),

                new Product("Blue iPhone 11",
                        470,
                        60,
                        "https://images.unsplash.com/photo-1616348436168-de43ad0db179?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2881&q=80",
                        "Electronics",
                        "Mobile Phone",
                        "My battery dies after two years so the company that made me can force you to replace me, which hurts my feelings tbh",
                        3),

                new Product("Samsung Note 20",
                        900,
                        10,
                        "https://images.unsplash.com/photo-1618478594486-c65b899c4936?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=987&q=80",
                        "Electronics",
                        "Mobile Phone",
                        "My battery dies after two years so the company that made me can force you to replace me, which hurts my feelings tbh",
                        3),

                new Product("Men's Grooming Kit",
                        30,
                        47,
                        "https://images.unsplash.com/photo-1621607512022-6aecc4fed814?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80",
                        "Electronics",
                        "Clippers",
                        "Beard trimmer with professional and finishing scissors to give a natural look with complimentary soothing oil",
                        4),

                new Product("Bose Over-ear Headphones",
                        140,
                        49,
                        "https://images.unsplash.com/photo-1520170350707-b2da59970118?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1065&q=80",
                        "Electronics",
                        "Headphones",
                        "Bose sleek black over-ear headphones with noise cancellation and ambient sound. Long battery life and 2 year warranty.",
                        5),

                new Product("Lounging chair",
                        32,
                        50,
                        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2030&q=80",
                        "Home",
                        "Chair",
                        "Black padded lounging chair with wooden frame which will flex to your comfort",4),

                //here

                new Product("Grey couch",
                        32,
                        50,
                        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2030&q=80",
                        "Home",
                        "Chair",
                        "Black padded lounging chair with wooden frame which will flex to your comfort",4),

                new Product("Flower pendant pearl necklace",
                        500,
                        10,
                        "https://images.unsplash.com/photo-1515562141207-7a88fb7ce338?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
                        "Jewellery",
                        "Necklace",
                        "Diamond encrusted 14-carat white gold surround in 50 spherical freshwater pearls. Length: 18 inches",4)
        );

        for (Product product : products) {
            Product productName = new Product(product.getName(),product.getPrice(),product.getAvailableQuantity(),product.getImageURL(),product.getCategory(),product.getItem(),product.getDescription(),product.getRating());
            productRepository.save(productName);
        }


    }

}
