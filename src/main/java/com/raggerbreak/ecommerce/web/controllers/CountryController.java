package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.domain.Country;
import com.raggerbreak.ecommerce.repositories.CountryRepository;
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

    private final CountryRepository countryRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}
