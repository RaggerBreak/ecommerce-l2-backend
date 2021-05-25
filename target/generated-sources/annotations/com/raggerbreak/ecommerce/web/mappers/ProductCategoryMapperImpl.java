package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.domain.ProductCategory;
import com.raggerbreak.ecommerce.dto.ProductCategoryDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-25T19:26:34+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class ProductCategoryMapperImpl implements ProductCategoryMapper {

    @Override
    public ProductCategory dtoToProductCategory(ProductCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductCategory productCategory = new ProductCategory();

        productCategory.setId( dto.getId() );
        productCategory.setCategoryName( dto.getCategoryName() );

        return productCategory;
    }

    @Override
    public ProductCategoryDto ProductCategoryToDto(ProductCategory productCategory) {
        if ( productCategory == null ) {
            return null;
        }

        ProductCategoryDto productCategoryDto = new ProductCategoryDto();

        productCategoryDto.setId( productCategory.getId() );
        productCategoryDto.setCategoryName( productCategory.getCategoryName() );

        return productCategoryDto;
    }
}
