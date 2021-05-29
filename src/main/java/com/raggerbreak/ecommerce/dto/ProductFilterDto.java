package com.raggerbreak.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductFilterDto {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
}
