//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PriceCalculatorService implements PriceCalculatorServiceInterface, ApplicationEventPublisherAware {
//    @Autowired
//    private BooksRepository booksRepository;
//    private ApplicationEventPublisher eventPublisher;
//
//    private final BooksRepository bookRepo;
//
//    public PriceCalculatorService(BooksRepository bookRepo) {
//        this.bookRepo = bookRepo;
//    }
//
//    public Optional<Book> getId(Long id) {
//        return bookRepo.findById(id);
//    }
//
//    public Book add(Book book) {
//        return bookRepo.save(book);
//    }
//
//    public Book findById(Long id) {
//        return bookRepo.findByIdAndDeletedAtIsNull(id);
//    }
//
//    public Book findByName(String name) {
//        return bookRepo.findByNameAndDeletedAtIsNull(name);
//    }
//
//    public Book findByPrice(int price) {
//        return bookRepo.findByFixPriceAndDeletedAtIsNull(price);
//    }
//
//
//    public String updatePrice(Long id, int price) {
//        Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
//        book.setFixPrice(price);
//        bookRepo.save(book);
//        return "price updated";
//    }
//
//    public String updateAll(Long id, String author, String genre, String name, int price) {
//        Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
//        book.setName(name);
//        book.setFixPrice(price);
//        bookRepo.save(book);
//        return "updated all";
//    }
//
//    public String delete(Long id) {
//        Date date = new Date();
//        Book book = bookRepo.findByIdAndDeletedAtIsNull(id);
//        book.setDeletedAt(date);
//        bookRepo.save(book);
//        return "deleted";
//    }
//
//    public List<Book> findAllByLibrary(Long id) {
//        return bookRepo.findAllByLibraryIdAndDeletedAtIsNull(id);
//    }
//
//
//    @Override
//    public List<Book> findAll() {
//        return booksRepository.findAll();
//    }
//
//    @Override
//    public List<Book> getByType(BookType bookType) {
//        return booksRepository.findBooksByBookType(bookType);
//    }
//
//    @Override
//    public Book findById(long id) {
//        return booksRepository.findBooksById(id);
//    }
//
//    @Override
//    public void save(Book book) {
//        booksRepository.save(book);
//    }
//
//    @Override
//    public void changePrice(long id, double salary) {
//        Book book = findById(id);
//        book.setFixPrice(salary);
//        save(book);
//        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
//    }
//
//    @Override
//    public void changeSoldBooks(long id, double sold) {
//        Book book = findById(id);
//        book.setSold(sold);
//        save(book);
//        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
//    }
//
//    @Override
//    public void changePercentageOfSales(long id, float percentage) {
//        Book book = findById(id);
//        book.setPercentageOfSales(percentage);
//        save(book);
//        this.eventPublisher.publishEvent(new PriceChangeEvent(this, book));
//    }
//
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.eventPublisher = applicationEventPublisher;
//    }
//
//}
