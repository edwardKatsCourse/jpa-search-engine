package com.example.searchenginedemo.repository;

import com.example.searchenginedemo.dto.ProductSearchDTO;
import com.example.searchenginedemo.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductSearchRepositoryImpl implements ProductSearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> searchProducts(ProductSearchDTO productSearchDTO) {

        Map<String, Object> paramsMap = new HashMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append(" from Product p where 1 = 1 ");

        // SELECT * FROM Product WHERE id in(1,2,3)


        // null || []
        if (productSearchDTO.getCategories() != null && !productSearchDTO.getCategories().isEmpty()) {
            builder.append(" and p.category in (:categories)");
            paramsMap.put("categories", productSearchDTO.getCategories());
        }

        if (productSearchDTO.getMaxRating() != null || productSearchDTO.getMinRating() != null) {

            if (productSearchDTO.getMaxRating() != null && productSearchDTO.getMinRating() != null) {

                builder.append(" and p.rating between :minRating and :maxRating");
                paramsMap.put("minRating", productSearchDTO.getMinRating());
                paramsMap.put("maxRating", productSearchDTO.getMaxRating());
            }

        }

        Query query = entityManager
                .createQuery(builder.toString());

        paramsMap.forEach(query::setParameter);

        return query.getResultList();
    }
}
