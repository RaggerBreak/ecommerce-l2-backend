package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.domain.Product;
import com.raggerbreak.ecommerce.dto.ProductDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-25T19:26:34+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product dtoToProduct(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setSku( dto.getSku() );
        product.setName( dto.getName() );
        product.setDescription( dto.getDescription() );
        product.setUnitPrice( dto.getUnitPrice() );
        product.setImageUrl( dto.getImageUrl() );
        product.setActive( dto.isActive() );
        product.setUnitsInStock( dto.getUnitsInStock() );
        product.setDateCreated( dto.getDateCreated() );
        product.setLastUpdated( dto.getLastUpdated() );

        return product;
    }

    @Override
    public ProductDto productToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setSku( product.getSku() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setUnitPrice( product.getUnitPrice() );
        productDto.setImageUrl( product.getImageUrl() );
        productDto.setActive( product.isActive() );
        productDto.setUnitsInStock( product.getUnitsInStock() );
        productDto.setDateCreated( product.getDateCreated() );
        productDto.setLastUpdated( product.getLastUpdated() );

        return productDto;
    }
}
