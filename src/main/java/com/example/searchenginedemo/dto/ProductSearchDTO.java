package com.example.searchenginedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSearchDTO {

    private Long id;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;


    private Integer minRating;
    private Integer maxRating;

    private List<String> categories;

}
