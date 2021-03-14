package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByBookType(BookType bookType);
    Book findBooksById(long id);
    List<Book> findAll();
}
