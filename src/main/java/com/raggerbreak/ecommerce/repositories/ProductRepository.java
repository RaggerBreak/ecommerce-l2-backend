package com.raggerbreak.ecommerce.repositories;

import com.raggerbreak.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
