package com.example.demo;

import java.util.List;

public interface PriceCalculatorServiceInterface {
    List<Book> findAll();
    List<Book> getByType(BookType bookType);
    Book findById(long id);

    void save(Book book);

    void changePrice(long id, double salary);

    void changeSoldBooks(long id, double sold);

    void changePercentageOfSales(long id, float percentage);
}
