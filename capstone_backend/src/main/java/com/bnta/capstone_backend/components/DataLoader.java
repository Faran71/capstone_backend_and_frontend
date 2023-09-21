package com.bnta.capstone_backend.components;

import com.bnta.capstone_backend.models.*;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import com.bnta.capstone_backend.repositories.ProductRepository;
import com.bnta.capstone_backend.repositories.ProductsOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // CUSTOMER DATA LOADER

        List<CustomerDTO> customers = Arrays.asList(
                new CustomerDTO()
        );

        for (CustomerDTO customer : customers) {
            Customer customerName = new Customer();
            customerRepository.save(customerName);
        }

        // PRODUCTS DATA LOADER

        List<ProductDTO> products = Arrays.asList(
                new ProductDTO("Kiikii",
                        100,
                        20,
                        "https://images.unsplash.com/photo-1576566588028-4147f3842f27?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1664&q=80",
                        "Clothes",
                        "T-Shirt",
                        "Plain white t-Shirt with a printed cat drawn on a canvas that's blue"),

                new ProductDTO("BNTA Macbook Pro",
                        1200,
                        5,
                        "https://images.unsplash.com/photo-1542393545-10f5cde2c810?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1665&q=80",
                        "Electronics",
                        "Free Macbook",
                        "BNTA im only going to do the hackathon to keep your laptop and in 2 weeks my dog will break it 😉"),

                new ProductDTO("Farans Chair",
                        100,
                        20,
                        "https://images.unsplash.com/photo-1547043736-b2247cb34b01?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1664&q=80",
                        "Home",
                        "Chair",
                        "Smoothest swivel on a chair known to mankind delived by the main man faran himself"),

                new ProductDTO("The Kite Runner",
                        15,
                        25,
                        "https://m.media-amazon.com/images/I/81CA-WqU+lL._AC_UF894,1000_QL80_.jpg",
                        "Books",
                        "Hardback fiction",
                        "Afghanistan, 1975: Twelve-year-old Amir is desperate to win the local kite-fighting tournament and his loyal friend Hassan promises to help him. But neither of the boys can foresee what will happen to Hassan that afternoon, an event that is to shatter their lives. After the Russians invade and the family is forced to flee to America, Amir realises that one day he must return to Afghanistan under Taliban rule to find the one thing that his new world cannot grant him: redemption"),

                new ProductDTO("Clinique liquid lipstick and solid lipstick duo",
                        32,
                        50,
                        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2030&q=80",
                        "Cosmetics",
                        "Lipstick",
                        "2-for-1 combination pack containing liquid and solid lipstick to fulfil your cosmetic dreams"),

                new ProductDTO("Flower pendant pearl necklace",
                        500,
                        10,
                        "https://images.unsplash.com/photo-1515562141207-7a88fb7ce338?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80",
                        "Jewellery",
                        "Necklace",
                        "Diamond encrusted 14-carat white gold surround in 50 spherical pearls. Length: 18 inches")
        );

        for (ProductDTO product : products) {
            Product bookName = new Product();
            productRepository.save(bookName);
        }

    }

}
