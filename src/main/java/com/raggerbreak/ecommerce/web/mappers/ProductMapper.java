package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.domain.Product;
import com.raggerbreak.ecommerce.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product dtoToProduct(ProductDto dto);

    @Mapping(target = "imageId", source = "product.image.id")
    ProductDto productToDto(Product product);

}
