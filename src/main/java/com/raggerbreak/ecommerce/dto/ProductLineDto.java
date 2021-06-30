package com.raggerbreak.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@Builder
public class ProductLineDto extends RepresentationModel {
    private List<ProductDto> products;

    @JsonProperty("page")
    private PageDto pageDto;
}

