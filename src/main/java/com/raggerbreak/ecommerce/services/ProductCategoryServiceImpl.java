package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductCategoryDto;
import com.raggerbreak.ecommerce.repositories.ProductCategoryRepository;
import com.raggerbreak.ecommerce.web.mappers.ProductCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryDto> getAll() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategoryMapper::ProductCategoryToDto)
                .collect(Collectors.toList());
    }
}
