package com.example.searchenginedemo.repository;

import com.example.searchenginedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends ProductSearchRepository, JpaRepository<Product, Long> {
}
