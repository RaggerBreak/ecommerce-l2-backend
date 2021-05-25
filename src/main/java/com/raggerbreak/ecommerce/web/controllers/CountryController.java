package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.domain.Country;
import com.raggerbreak.ecommerce.services.CountryService;
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
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Country>> getAllCountries() {

        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

}
