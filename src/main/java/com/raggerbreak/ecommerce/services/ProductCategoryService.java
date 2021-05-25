package com.raggerbreak.ecommerce.services;

import com.raggerbreak.ecommerce.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDto> getAll();
}
