package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductDto;
import com.raggerbreak.ecommerce.repositories.ProductRepository;
import com.raggerbreak.ecommerce.web.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::productToDto)
                .orElse(null);
    }

    @Override
    public Page<ProductDto> getProductsByCategory(Long categoryId, Pageable pageable) {

        return productRepository.findByCategoryId(categoryId, pageable)
                .map(productMapper::productToDto);
    }

    @Override
    public Page<ProductDto> getProductsByNameContaining(String keyword, Pageable pageable) {
        return productRepository.findByNameContaining(keyword, pageable)
                .map(productMapper::productToDto);
    }
}
