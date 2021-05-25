package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    ProductDto getProduct(Long productId);
    Page<ProductDto> getProductsByCategory(Long categoryId, Pageable pageable);
    Page<ProductDto> getProductsByNameContaining(String keyword, Pageable pageable);
}
