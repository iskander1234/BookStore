package com.example.demo;


import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixPrice;
    private double sold;
    private int percentageOfSales;
    @Enumerated(EnumType.STRING)
    private BookType bookType;

    public Book(Long id, String name, double fixPrice, double sold, int percentageOfSales, BookType bookType) {
        this.id = id;
        this.name = name;
        this.fixPrice = fixPrice;
        this.sold = sold;
        this.percentageOfSales = percentageOfSales;
        this.bookType = bookType;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getFixPrice() {
        return fixPrice;
    }

    public double getSold() {
        return sold;
    }

    public int getPercentageOfSales() {
        return percentageOfSales;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFixPrice(double fixPrice) {
        this.fixPrice = fixPrice;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public void setPercentageOfSales(int percentageOfSales) {
        this.percentageOfSales = percentageOfSales;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
