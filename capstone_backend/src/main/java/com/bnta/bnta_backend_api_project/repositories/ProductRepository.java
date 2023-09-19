package com.bnta.bnta_backend_api_project.repositories;

import com.bnta.bnta_backend_api_project.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("from book")
    List<Book> findAllBook();
    @Query("from movie")
    List<Movie> findAllMovie();
    @Query("from music")
    List<Music> findAllMusic();

    @Query(value = "SELECT * FROM product WHERE media_type = 'book' AND title LIKE %?1%", nativeQuery = true)
    List<Book> findBookByTitle(String title);

    @Query(value = "SELECT * FROM product WHERE media_type = 'music' AND title LIKE %?1%", nativeQuery = true)
    List<Music> findMusicByTitle(String title);

    @Query(value = "SELECT * FROM product WHERE media_type = 'movie' AND title LIKE %?1%", nativeQuery = true)
    List<Movie> findMovieByTitle(String title);


//// check these
//    @Query(value = "SELECT * FROM product WHERE media_type = 'book' AND title  = :?1", nativeQuery = true)
//    Book find1BookByTitle(String title);
//
//    @Query(value = "SELECT * FROM product WHERE media_type = 'music' AND title = :?1", nativeQuery = true)
//    Music find1MusicByTitle(String title);
//
//    @Query(value = "SELECT * FROM product WHERE media_type = 'movie' AND title = :?1", nativeQuery = true)
//    Movie find1MovieByTitle(String title);

//    @Modifying
//    @Query("from book update  u set u.phone = :phone where u.id = :id")
//    void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);
    //https://www.baeldung.com/spring-data-partial-update







}


