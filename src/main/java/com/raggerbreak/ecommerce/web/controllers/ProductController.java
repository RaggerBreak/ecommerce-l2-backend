package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.dto.ProductDto;
import com.raggerbreak.ecommerce.dto.ProductFilterDto;
import com.raggerbreak.ecommerce.dto.ProductLineDto;
import com.raggerbreak.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long productId) {
        return new ResponseEntity<ProductDto>(productService.getProduct(productId), HttpStatus.OK);
    }

    @GetMapping("/search/category")
    public ResponseEntity<ProductLineDto> getProductsByCategory(@RequestParam("id") Long categoryId,
                                                                @RequestParam int page,
                                                                @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<ProductLineDto>(productService.getProductsByCategory(categoryId, pageable), HttpStatus.OK);
    }

    @PostMapping("/search/categoryFilter")
    public ResponseEntity<ProductLineDto> getProductsByCategoryWithFilter(@RequestParam("id") Long categoryId,
                                                                          @RequestParam int page,
                                                                          @RequestParam int size,
                                                                          @RequestBody ProductFilterDto productFilterDto) {
        Pageable pageable = PageRequest.of(page, size);

        return new ResponseEntity<ProductLineDto>(productService.getProductsWithFilter(categoryId, productFilterDto, pageable), HttpStatus.OK);
    }

    @GetMapping("/search/nameContaining")
    public ResponseEntity<ProductLineDto> getProductsByNameContaining(@RequestParam String name,
                                                                      @RequestParam int page,
                                                                      @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);

        return new ResponseEntity<ProductLineDto>(productService.getProductsByNameContaining(name, pageable), HttpStatus.OK);
    }
}
