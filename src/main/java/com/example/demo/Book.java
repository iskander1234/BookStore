package com.example.demo;


import com.example.demo.model.AuditModel;
import com.example.demo.model.Library;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "seq",
        sequenceName = "s_book",
        initialValue = 1,
        allocationSize = 1
)
public class Book extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double fixPrice;
    private double sold;
    private float percentageOfSales;
    @Enumerated(EnumType.STRING)
    private BookType bookType;
    @ManyToOne
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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

    public float getPercentageOfSales() {
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

    public void setPercentageOfSales(float percentageOfSales) {
        this.percentageOfSales = percentageOfSales;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
