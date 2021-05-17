package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
