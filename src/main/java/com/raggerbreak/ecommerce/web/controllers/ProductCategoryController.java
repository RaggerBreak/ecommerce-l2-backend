package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.dto.ProductCategoryDto;
import com.raggerbreak.ecommerce.services.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/productCategory")
@RequiredArgsConstructor
public class ProductCategoryController {

private final ProductCategoryService productCategoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductCategoryDto>> getAll() {

        return new ResponseEntity<>(productCategoryService.getAll(), HttpStatus.OK);
    }
}
