package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.dto.ProductDto;
import com.raggerbreak.ecommerce.dto.ProductFilterDto;
import com.raggerbreak.ecommerce.dto.ProductLineDto;
import com.raggerbreak.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<EntityModel<ProductDto>> getProductById(@PathVariable Long productId) {
        ProductDto product = productService.getProduct(productId);

        //  Link link = linkTo(ProductController.class).slash(productId).withSelfRel();
        Link link = linkTo(methodOn(ProductController.class).getProductById(productId)).withSelfRel();

        EntityModel<ProductDto> productDtoEntityModel = EntityModel.of(product, link);


        return new ResponseEntity<EntityModel<ProductDto>>(productDtoEntityModel, HttpStatus.OK);
    }

    @GetMapping("/search/category")
    public ResponseEntity<EntityModel<ProductLineDto>> getProductsByCategory(@RequestParam("id") Long categoryId,
                                                                @RequestParam int page,
                                                                @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);

        ProductLineDto productLineDto = productService.getProductsByCategory(categoryId, pageable);

        addLinksToProducts(productLineDto);

        Link link = linkTo(methodOn(ProductController.class).getProductsByCategory(categoryId, page, size)).withSelfRel();
        EntityModel<ProductLineDto> lineDtoEntityModel = EntityModel.of(productLineDto, link);

        return new ResponseEntity<EntityModel<ProductLineDto>>(lineDtoEntityModel, HttpStatus.OK);
    }

    @PostMapping("/search/categoryFilter")
    public ResponseEntity<EntityModel<ProductLineDto>> getProductsByCategoryWithFilter(@RequestParam("id") Long categoryId,
                                                                          @RequestParam int page,
                                                                          @RequestParam int size,
                                                                          @RequestBody ProductFilterDto productFilterDto) {
        Pageable pageable = PageRequest.of(page, size);

        ProductLineDto productsWithFilter = productService.getProductsWithFilter(categoryId, productFilterDto, pageable);

        addLinksToProducts(productsWithFilter);

        Link link = linkTo(methodOn(ProductController.class)
                .getProductsByCategoryWithFilter(categoryId, page, size, productFilterDto))
                .withSelfRel();

        EntityModel<ProductLineDto> lineDtoEntityModel = EntityModel.of(productsWithFilter, link);

        return new ResponseEntity<EntityModel<ProductLineDto>>(lineDtoEntityModel, HttpStatus.OK);
    }

    @GetMapping("/search/nameContaining")
    public ResponseEntity<EntityModel<ProductLineDto>> getProductsByNameContaining(@RequestParam String name,
                                                                      @RequestParam int page,
                                                                      @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);

        ProductLineDto productsByNameContaining = productService.getProductsByNameContaining(name, pageable);

        addLinksToProducts(productsByNameContaining);

        Link link = linkTo(methodOn(ProductController.class)
                .getProductsByNameContaining(name, page, size))
                .withSelfRel();

        EntityModel<ProductLineDto> lineDtoEntityModel = EntityModel.of(productsByNameContaining, link);

        return new ResponseEntity<EntityModel<ProductLineDto>>(lineDtoEntityModel, HttpStatus.OK);
    }

    public void addLinksToProducts(ProductLineDto productLineDto) {
        productLineDto.getProducts()
                .forEach(product -> product.add(
                        linkTo(methodOn(ProductController.class).getProductById(product.getId())).withSelfRel()
                ));
    }
}
