package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.dto.ProductCategoryDto;
import com.raggerbreak.ecommerce.repositories.ProductCategoryRepository;
import com.raggerbreak.ecommerce.web.mappers.ProductCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductCategoryDto>> getAll() {
        List<ProductCategoryDto> productCategories = productCategoryRepository.findAll()
                .stream()
                .map(productCategoryMapper::ProductCategoryToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(productCategories, HttpStatus.OK);
    }
}
