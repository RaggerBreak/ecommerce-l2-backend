package com.raggerbreak.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductLineDto {
    private List<ProductDto> products;

    @JsonProperty("page")
    private PageDto pageDto;
}

