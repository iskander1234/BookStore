package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class PriceChangeEventHandler implements ApplicationListener<PriceChangeEvent> {
    @Override
    @EventListener
    public void onApplicationEvent(PriceChangeEvent priceChangeEvent) {
        System.out.println(priceChangeEvent.book.getName() + "'информация о цене изменилась.");
    }
}
