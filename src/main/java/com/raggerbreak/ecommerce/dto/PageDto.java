package com.raggerbreak.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageDto {

    private int size;
    private long totalElements;
    private int totalPages;
    private int number;
}
