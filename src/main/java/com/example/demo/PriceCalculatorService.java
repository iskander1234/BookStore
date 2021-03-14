package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PriceCalculatorService implements PriceCalculatorServiceInterface, ApplicationEventPublisherAware {
    @Autowired
    private BooksRepository booksRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public List<Book> getByType(BookType bookType) {
        return booksRepository.findBooksByBookType(bookType);
    }

    @Override
    public Book findById(long id) {
        return booksRepository.findBooksById(id);
    }

    @Override
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Override
    public void changePrice(long id, double salary) {
        Book book = findById(id);
        book.setFixPrice(salary);
        save(book);
        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
    }

    @Override
    public void changeSoldBooks(long id, double sold) {
        Book book = findById(id);
        book.setSold(sold);
        save(book);
        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
    }

    @Override
    public void changePercentageOfSales(long id, float percentage) {
        Book book = findById(id);
        book.setPercentageOfSales(percentage);
        save(book);
        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
