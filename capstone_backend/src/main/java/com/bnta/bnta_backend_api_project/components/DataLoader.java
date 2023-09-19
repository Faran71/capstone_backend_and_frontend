package com.bnta.bnta_backend_api_project.components;

import com.bnta.bnta_backend_api_project.models.*;
import com.bnta.bnta_backend_api_project.repositories.CustomerRepository;
import com.bnta.bnta_backend_api_project.repositories.OrdersRepository;
import com.bnta.bnta_backend_api_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // CUSTOMER DATA LOADER

        List<Customer> customers = Arrays.asList(
              new Customer("cust1","email1","5678"),
                new Customer("cust2","email2","5678"),
                new Customer("cust3","email3","5678"),
                new Customer("cust4","email4","5678")
        );

        for (Customer customer : customers) {
            Customer customerName = new Customer(customer.getName(), customer.getEmail(), customer.getCardNumber());
            customerRepository.save(customerName);
        }

        // PRODUCTS DATA LOADER

        List<Book> books = new ArrayList<>(Arrays.asList(
                new Book("JK Rowling", "Harry Potter and the Philosopher's Stone", 13, 11, 40, 2001, 500,"/images/books/hp.jpg"),
                new Book("George Orwell", "1984", 43, 11, 30, 1949, 350,"/images/books/1984.jpg"),
                new Book("J.R.R. Tolkien", "The Lord of the Rings", 12, 11, 20, 1954, 1170,"/images/books/lotr.jpg"),
                new Book("Agatha Christie", "Murder on the Orient Express", 533, 11, 10, 1934, 250,"/images/books/Murder_on_the_Orient_Express_First_Edition_Cover_1934.jpeg"),
                new Book("Khalid Hosseini", "The Kite Runner", 433, 11, 0, 2003, 370,"/images/books/Kite_runner.jpeg")
        ));

        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Francis Ford Coppola", "The Godfather", 175, 12, 10, 9.2, 100,"/images/movies/the-godfather.jpeg"),
                new Movie("Quentin Tarantino", "Pulp Fiction", 154, 18, 20, 8.9, 110,"/images/movies/pulp-fiction.jpeg"),
                new Movie("Christopher Nolan", "Inception", 148, 12, 30, 8.8, 130,"/images/movies/inception.jpeg"),
                new Movie("Steven Spielberg", "Jurassic Park", 127, 7, 0, 8.1, 120,"/images/movies/jurassic-park.jpeg")
        ));

        List<Music> songs = new ArrayList<>(Arrays.asList(
                new Music("The Beatles", "Hey Jude", 5, 12, 100, "1970", 200,"/images/music/hey-jude-album-cover.jpeg"),
                new Music("Queen", "Bohemian Rhapsody", 6, 12, 50, "1980", 210,"/images/music/bohemian-rhapsody-album-cover.jpeg"),
                new Music("Michael Jackson", "Billie Jean", 4, 12, 25, "2000", 190,"/images/music/billie-jean-album-cover.jpeg"),
                new Music("Bob Marley", "No Woman, No Cry", 7, 12, 0, "2010", 180,"/images/music/no-woman-no-cry-album-cover.jpeg")
        ));



        for (Book book : books) {
            Book bookName = new Book(book.getCreator(),book.getTitle(),book.getPrice(),book.getCost(),book.getAvailableQuantity(),book.getYearOfPublication(),book.getNoOfPages(),book.getImage());
            productRepository.save(bookName);
        }

        for (Movie movie : movies) {
            Movie movieName = new Movie(movie.getCreator(),movie.getTitle(),movie.getPrice(),movie.getCost(),movie.getAvailableQuantity(),movie.getRating(),movie.getRunTime(), movie.getImage());
            productRepository.save(movieName);
        }

        for (Music music : songs) {
            Music musicName = new Music(music.getCreator(),music.getTitle(),music.getPrice(),music.getCost(),music.getAvailableQuantity(),music.getDecade(),music.getSongLength(), music.getImage());
            productRepository.save(musicName);
        }

    }
}
