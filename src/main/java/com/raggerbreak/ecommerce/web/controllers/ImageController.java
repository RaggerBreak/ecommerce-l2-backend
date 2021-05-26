package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImageById(@PathVariable Long imageId) {
        return new ResponseEntity<byte[]>(imageService.getImage(imageId), HttpStatus.OK);
    }
}
