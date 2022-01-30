package com.example.searchenginedemo.controller;

import com.example.searchenginedemo.dto.ProductSearchDTO;
import com.example.searchenginedemo.entity.Product;
import com.example.searchenginedemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/products")
    public List<Product> getAllProducts(@RequestBody ProductSearchDTO productSearch) {
        return productRepository.searchProducts(productSearch);
    }

    @GetMapping("/products/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
