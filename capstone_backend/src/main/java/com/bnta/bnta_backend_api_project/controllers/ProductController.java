package com.bnta.bnta_backend_api_project.controllers;

import com.bnta.bnta_backend_api_project.models.*;
import com.bnta.bnta_backend_api_project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/products"})
public class ProductController {

    @Autowired
    ProductService productService;

//    INDEX

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    @GetMapping({"/books"})
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = productService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.FOUND);
    }

    @GetMapping({"/movies"})
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = productService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

    @GetMapping({"/songs"})
    public ResponseEntity<List<Music>> getAllSongs() {
        List<Music> songs = productService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.FOUND);
    }

//SHOW

    @GetMapping("/books/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        List<Book> books = productService.getBookByTitle(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/songs/{title}")
    public ResponseEntity<List<Music>> getMusicByTitle(@PathVariable String title) {
        List<Music> songs = productService.getMusicByTitle(title);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<List<Movie>> getMovieByTitle(@PathVariable String title) {
        List<Movie> movies = productService.getMovieByTitle(title);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

//CREATE

    @PostMapping("/addBook")
    public ResponseEntity<Book> postBook(@RequestBody BookDTO bookDTO) {
        Book newBook = productService.addBook(bookDTO);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PostMapping("/addSong")
    public ResponseEntity<Music> postMusic(@RequestBody MusicDTO musicDTO) {

        Music newSong = productService.addSong(musicDTO);
        return new ResponseEntity<>(newSong, HttpStatus.CREATED);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<Movie> postMovie(@RequestBody MovieDTO movieDTO) {
        Movie newMovie = productService.addMovie(movieDTO);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    // UPDATE can perform get by title methods first if user forgets the id they want to update

    @PutMapping(value = "/updateProduct/{availableQuantity}/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int availableQuantity, @PathVariable Long id) {
        Product updateProduct = productService.updateProduct(availableQuantity, id);
        return new ResponseEntity(updateProduct, HttpStatus.OK);
    }

    //    DELETE
    @DeleteMapping(value = "/deleteProduct/{id}")
    public ResponseEntity<Long> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

