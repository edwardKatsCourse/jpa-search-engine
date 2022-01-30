package com.example.searchenginedemo.repository;

import com.example.searchenginedemo.dto.ProductSearchDTO;
import com.example.searchenginedemo.entity.Product;

import java.util.List;



public interface ProductSearchRepository {

    List<Product> searchProducts(ProductSearchDTO productSearchDTO);
}
