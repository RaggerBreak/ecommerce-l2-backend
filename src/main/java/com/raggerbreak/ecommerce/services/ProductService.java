package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductDto;
import com.raggerbreak.ecommerce.dto.ProductFilterDto;
import com.raggerbreak.ecommerce.dto.ProductLineDto;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    ProductDto getProduct(Long productId);
    ProductLineDto getProductsByCategory(Long categoryId, Pageable pageable);
    ProductLineDto getProductsByNameContaining(String keyword, Pageable pageable);
    ProductLineDto getProductsWithFilter(Long categoryId, ProductFilterDto productFilterDto, Pageable pageable);
}
