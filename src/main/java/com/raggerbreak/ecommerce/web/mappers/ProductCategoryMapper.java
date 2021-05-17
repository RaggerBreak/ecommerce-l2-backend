package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.domain.ProductCategory;
import com.raggerbreak.ecommerce.dto.ProductCategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    ProductCategory dtoToProductCategory(ProductCategoryDto dto);
    ProductCategoryDto ProductCategoryToDto(ProductCategory productCategory);

}
