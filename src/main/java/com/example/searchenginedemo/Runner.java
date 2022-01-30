package com.example.searchenginedemo;

import com.example.searchenginedemo.entity.Product;
import com.example.searchenginedemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class Runner implements CommandLineRunner {

    // spring "main"

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {

        Stream.generate(ProductGenerator::getProduct)
                .limit(100)
                .forEach(productRepository::save);

    }
}


class ProductGenerator {

    private static final Random random = new Random();

    private static final String[] CATEGORIES = {
            "Computer",
            "Laptop",
            "Smart Watch",
            "Headphones",
            "Smartphone"
    };

    private static final Double MIN_PRICE = 1.;
    private static final Double MAX_PRICE = 299.;

    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 6;

    public static String getProductName() {

        return String.format("product-%s", random.nextInt(10000));
    }

    public static String getProductCategory() {
        return CATEGORIES[random.nextInt(CATEGORIES.length)].toLowerCase();
    }

    public static BigDecimal getPrice() {
        double price = MIN_PRICE + (MAX_PRICE - MIN_PRICE) * random.nextDouble();
        return new BigDecimal(price);
    }

    public static int getRating() {
        return random.nextInt(MAX_RATING - MIN_RATING) + MIN_RATING;
    }

    public static Product getProduct() {
        return Product.builder()
                .price(getPrice())
                .name(getProductName())
                .category(getProductCategory())
                .rating(getRating())
                .build();
    }

}