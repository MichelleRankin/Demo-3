package com.example.demo.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository
        extends JpaRepository<Book, Long> {

    @Query("SELECT s FROM Book s WHERE s.author = ?1")
    Optional<Book> findBookByAuthor(String author);


}
