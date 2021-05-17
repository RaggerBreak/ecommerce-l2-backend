package com.raggerbreak.ecommerce.dto;

import lombok.Data;

@Data // for JSON serializer
public class ProductCategoryDto {
    private Long id;
    private String categoryName;
}
