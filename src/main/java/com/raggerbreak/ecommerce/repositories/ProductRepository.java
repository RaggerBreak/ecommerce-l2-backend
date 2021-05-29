package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByCategoryId(Long id, Pageable pageable);
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Product> findByCategoryIdAndUnitPriceBetween(Long id, BigDecimal min, BigDecimal max, Pageable pageable);
    Page<Product> findByCategoryIdAndUnitPriceLessThanEqual(Long id, BigDecimal max, Pageable pageable);
    Page<Product> findByCategoryIdAndUnitPriceGreaterThanEqual(Long id, BigDecimal min, Pageable pageable);

}
