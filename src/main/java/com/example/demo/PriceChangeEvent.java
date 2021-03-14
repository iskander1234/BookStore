package com.example.demo;

import org.springframework.context.ApplicationEvent;

public class PriceChangeEvent extends ApplicationEvent {
    Book book;
    public PriceChangeEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }
}
