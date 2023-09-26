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
                new Product("Kiikii",
                        100,
                        20,
                        "https://images.unsplash.com/photo-1576566588028-4147f3842f27?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1664&q=80",
                        "Clothes",
                        "T-Shirt"),


                new Product("BNTA Macbook Pro",
                        1200,
                        5,
                        "https://images.unsplash.com/photo-1542393545-10f5cde2c810?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1665&q=80",
                        "Electronics",
                        "Free Macbook",
                        "BNTA im only going to do the hackathon to keep your laptop and in 2 weeks my dog will break it 😉",3),

                new Product("Farans Chair",
                        100,
                        20,
                        "https://images.unsplash.com/photo-1547043736-b2247cb34b01?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1664&q=80",
                        "Home",
                        "Chair",
                        "Smoothest swivel on a chair known to mankind delivered by the main man Faran himself",5),

                new Product("The Kite Runner",
                        15,
                        25,
                        "https://m.media-amazon.com/images/I/81CA-WqU+lL._AC_UF894,1000_QL80_.jpg",
                        "Books",
                        "Hardback fiction",
                        "Afghanistan, 1975: Twelve-year-old Amir is desperate to win the local kite-fighting tournament and his loyal friend Hassan promises to help him. But neither of the boys can foresee what will happen to Hassan that afternoon, an event that is to shatter their lives. After the Russians invade and the family is forced to flee to America, Amir realises that one day he must return to Afghanistan under Taliban rule to find the one thing that his new world cannot grant him: redemption",4),

                new Product("Clinique liquid lipstick and solid lipstick duo",
                        32,
                        50,
                        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2030&q=80",
                        "Cosmetics",
                        "Lipstick",
                        "2-for-1 combination pack containing liquid and solid lipstick to fulfil your cosmetic dreams",1),

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
