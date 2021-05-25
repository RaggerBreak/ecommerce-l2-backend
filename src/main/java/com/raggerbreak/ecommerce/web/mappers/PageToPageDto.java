package com.raggerbreak.ecommerce.web.mappers;

import com.raggerbreak.ecommerce.dto.PageDto;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageToPageDto implements Converter<Page, PageDto> {

    @Synchronized
    @Override
    public PageDto convert(Page page) {

        if (page == null) {
            return null;
        }

        return PageDto.builder()
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .number(page.getNumber())
                .build();
    }
}
