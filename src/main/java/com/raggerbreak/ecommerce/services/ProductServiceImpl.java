package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductDto;
import com.raggerbreak.ecommerce.dto.ProductLineDto;
import com.raggerbreak.ecommerce.repositories.ProductRepository;
import com.raggerbreak.ecommerce.web.mappers.PageToPageDto;
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
    private final PageToPageDto pageToPageDto;

    @Override
    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::productToDto)
                .orElse(null);
    }

    @Override
    public ProductLineDto getProductsByCategory(Long categoryId, Pageable pageable) {


        Page<ProductDto> page = productRepository.findByCategoryId(categoryId, pageable)
                .map(productMapper::productToDto);

        return ProductLineDto.builder()
                .products(page.getContent())
                .pageDto(pageToPageDto.convert(page))
                .build();

    }

    @Override
    public ProductLineDto getProductsByNameContaining(String keyword, Pageable pageable) {


        Page<ProductDto> page = productRepository.findByNameContaining(keyword, pageable)
                .map(productMapper::productToDto);

        return ProductLineDto.builder()
                .products(page.getContent())
                .pageDto(pageToPageDto.convert(page))
                .build();
    }
}
