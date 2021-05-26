package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    ProductCategory findByCategoryName(String category);
}
