package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.domain.Product;
import com.raggerbreak.ecommerce.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product dtoToProduct(ProductDto dto);
    ProductDto productToDto(Product product);
}
