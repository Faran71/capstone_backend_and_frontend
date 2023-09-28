package com.bnta.capstone_backend.components;

import com.bnta.capstone_backend.models.*;
import com.bnta.capstone_backend.repositories.CustomerRepository;
import com.bnta.capstone_backend.repositories.ProductRepository;
import com.bnta.capstone_backend.repositories.ReviewRepository;
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
    ReviewRepository reviewRepository;

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
                        90,
                        50,
                        "https://images.unsplash.com/photo-1617364852223-75f57e78dc96?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjZ8fGNoYWlyfGVufDB8fDB8fHwy&auto=format&fit=crop&w=800&q=60",
                        "Home",
                        "Chair",
                        "Black padded lounging chair with wooden frame which will flex to your comfort",4),

                //here

                new Product("Grey couch",
                        320,
                        50,
                        "https://images.unsplash.com/photo-1583847268964-b28dc8f51f92?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80",
                        "Home",
                        "Chair",
                        "Black padded lounging chair with wooden frame which will flex to your comfort",4),

                new Product("Bed-side Lamp",
                        40,
                        40,
                        "https://images.unsplash.com/photo-1534105615256-13940a56ff44?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dGFibGUlMjBsYW1wc3xlbnwwfHwwfHx8Mg%3D%3D&auto=format&fit=crop&w=800&q=60",
                        "Home",
                        "Lamp",
                        "Black lamp with hints of Gold. Perfect for use on a Bed-side table allowing for a brighter room with a guarantee of 20 years. Energy efficient bulb with a power rating of 20W.",
                        4),
                new Product("Glass Candle",
                        5,
                        200,
                        "https://images.unsplash.com/photo-1603006905003-be475563bc59?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2787&q=80",
                        "Home",
                        "Candle",
                        "A vanilla scented candle encompassed in a strong glass cup to prevent any damage when dropped. The candle has a shelf life of many years and can burn for many hours at a time. Just make sure to not leave it burning when no one is around.",
                        3),
                new Product("Limited Edition Harry Potter Collection",
                        89,
                        50,
                        "https://images.unsplash.com/photo-1606311698062-21c4f57cb27f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2858&q=80",
                        "Books",
                        "Harry Potter Collection",
                        "Want to read into the life of Harry Potter. Collection containing: Harry Potter and The Sorcerer's Stone + Chamber of Secrets + Prisoner of Azkaban + Goblet of Fire + Order of the Phoenix + Half-Blood Prince + Deathly Hallows. A complete collection for any enthusiast.",
                        5),
                new Product("The Kite Runner",
                        15,
                        25,
                        "https://m.media-amazon.com/images/I/81CA-WqU+lL._AC_UF894,1000_QL80_.jpg",
                        "Books",
                        "Hardback Fiction",
                        "Afghanistan, 1975: Twelve-year-old Amir is desperate to win the local kite-fighting tournament and his loyal friend Hassan promises to help him. But neither of the boys can foresee what will happen to Hassan that afternoon, an event that is to shatter their lives. After the Russians invade and the family is forced to flee to America, Amir realises that one day he must return to Afghanistan under Taliban rule to find the one thing that his new world cannot grant him: redemption",
                        3),

                new Product("Clinique liquid lipstick and solid lipstick duo",
                        32,
                        50,
                        "https://images.unsplash.com/photo-1586495777744-4413f21062fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2030&q=80",
                        "Cosmetics",
                        "Lipstick",
                        "2-for-1 combination pack containing liquid and solid lipstick to fulfil your cosmetic dreams",
                        3),
                new Product("NEAUTHY cream",
                        60,
                        33,
                        "https://images.unsplash.com/photo-1601049541289-9b1b7bbbfe19?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2786&q=80",
                        "Cosmetics",
                        "Cream",
                        "Wanna keep your sking hydrated and moisturised? This cream provides you a solution to your problem. Once applied, it will keep your skin looking fresh for 24 hours.",
                        2),







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

        //REVIEW DATA LOADER

        List<Review> reviews = Arrays.asList(
                new Review("Zsolt", "The most comfortable trousers I have purchased in a long time, will definitely be repurchasing in different colours! However, you may need to size down as they are a little loose  around the waist for me",products.get(3) )
        );


        for (Review review : reviews) {
            Review reviewName = new Review(review.getName(),review.getReviewContent(), review.getProduct());
            reviewRepository.save(reviewName);
        }


    }

}
