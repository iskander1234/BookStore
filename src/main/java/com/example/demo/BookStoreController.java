package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class BookStoreController {
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
    @Autowired
    PriceCalculatorServiceInterface priceCalculatorServiceInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    @PostConstruct
    public void showMenu() {
        int choice = 0;
        while (choice != 6) {
            int i = 0;
            System.out.println("1. Рассчет книг");
            System.out.println("2. Изменить продаж книг");
            System.out.println("3. Изменить процент прожаж книг");
            System.out.println("4. Изменить цену за книгу");
            System.out.println("5. Список всех книг");
            System.out.println("6. Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Не востребованные книги : ");
                    List<Book> books = priceCalculatorServiceInterface.getByType(BookType.Not_In_Demand);
                    System.out.println(" --" +books.size() + " книг есть.");
                    i = 1;
                    for (Book employee: books) {
                        System.out.println(i + ") " + employee.getName() + ": " + employee.getFixPrice() + " тг");
                        i++;
                    }
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Популярные книги: ");
                    books = priceCalculatorServiceInterface.getByType(BookType.Popular);
                    System.out.println(" --" +books.size() + " книг есть.");
                    i = 1;
                    for (Book book: books) {
                        double price = (book.getFixPrice() * book.getSold());
                        System.out.println(i + ") " + book.getName() + ": " + df2.format(price) + " тг");
                        i++;
                    }
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Востребованные книги: ");
                    books = priceCalculatorServiceInterface.getByType(BookType.In_Demand);
                    System.out.println(" --" +books.size() + " книг есть.");
                    i = 1;
                    for (Book book: books) {
                        double price = ((book.getFixPrice() + book.getSold() * book.getPercentageOfSales()));
                        System.out.println(i + ") " + book.getName() + ": " + df2.format(price) + " тг");
                        i++;
                    }
                    System.out.println();
                }
                break;
                case 2: {
                    System.out.println("\n----------------------------------------------------------------\n\n");
                    System.out.println("Введите идентификатор книги: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую продажную значения : ");
                    double sold = scan.nextDouble();
                    priceCalculatorServiceInterface.changeSoldBooks(id,sold);
                }
                break;
                case 3: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Введите идентификатор книги: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую процентную ставку : ");
                    float percent = scan.nextFloat();
                    priceCalculatorServiceInterface.changePercentageOfSales(id,percent);

                }
                break;
                case 4: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    System.out.println("Введите идентификатор книги: ");
                    int id = scan.nextInt();
                    System.out.println("Введите новую цену: ");
                    double price = scan.nextDouble();
                    priceCalculatorServiceInterface.changePrice(id, price);
                }
                break;
                case 5: {
                    System.out.println("\n----------------------------------------------------------------\n");
                    i = 0;
                    List<Book> books = priceCalculatorServiceInterface.findAll();
                    System.out.println("Общее количество книг: " + books.size());
                    for (Book book : books) {
                        String name = book.getName();
                        long id = book.getId();
                        System.out.println("Идентификатор: " + id+ " - " + name + " - Тип : " + book.getBookType());
                    }
                }
                break;
                default: {

                }
            }
        }
    }
}
