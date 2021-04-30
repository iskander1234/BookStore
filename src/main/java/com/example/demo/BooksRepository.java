package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    Book findByIdAndDeletedAtIsNull(long id);
    Book findByNameAndDeletedAtIsNull(String name);
    Book findByFixPriceAndDeletedAtIsNull(int price);
    List<Book> findAllByDeletedAtIsNull();
    List<Book> findAllByLibraryIdAndDeletedAtIsNull(long id);
    List<Book> findBooksByBookType(BookType bookType);
    Book findBooksById(long id);
    List<Book> findAll();
}
