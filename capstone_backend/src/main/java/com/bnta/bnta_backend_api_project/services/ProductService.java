package com.bnta.bnta_backend_api_project.services;

import com.bnta.bnta_backend_api_project.models.*;
import com.bnta.bnta_backend_api_project.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Book> getAllBooks() {
        return productRepository.findAllBook();
    }

    public List<Movie> getAllMovies() {
        return productRepository.findAllMovie();
    }

    public List<Music> getAllSongs() {
        return productRepository.findAllMusic();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Book> getBookByTitle(String title) {
        return productRepository.findBookByTitle(title);
    }

    public List<Music> getMusicByTitle(String title) {
        return productRepository.findMusicByTitle(title);
    }

    public List<Movie> getMovieByTitle(String title) {
        return productRepository.findMovieByTitle(title);
    }

    public Book addBook(BookDTO bookDTO) {
        Book newBook = new Book(
                bookDTO.getCreator(),
                bookDTO.getTitle(),
                bookDTO.getPrice(),
                bookDTO.getCost(),
                bookDTO.getAvailableQuantity(),
                bookDTO.getYearOfPublication(),
                bookDTO.getNoOfPages(),"");
        return this.productRepository.save(newBook);
    }

    public Music addSong(MusicDTO musicDTO) {
        Music newSong = new Music(
                musicDTO.getCreator(),
                musicDTO.getTitle(),
                musicDTO.getPrice(),
                musicDTO.getCost(),
                musicDTO.getAvailableQuantity(),
                musicDTO.getDecade(),
                musicDTO.getSongLength(),"");
        return this.productRepository.save(newSong);
    }

    public Movie addMovie(MovieDTO movieDTO) {
        Movie newMovie = new Movie(
                movieDTO.getCreator(),
                movieDTO.getTitle(),
                movieDTO.getPrice(),
                movieDTO.getCost(),
                movieDTO.getAvailableQuantity(),
                movieDTO.getRating(),
                movieDTO.getRunTime(),"");
        return this.productRepository.save(newMovie);
    }

    public Product updateProduct(int availableQuantity, Long id) {
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setAvailableQuantity(availableQuantity);
        productRepository.save(productToUpdate);
        return productToUpdate;
    }

    //DELETE METHOD
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
