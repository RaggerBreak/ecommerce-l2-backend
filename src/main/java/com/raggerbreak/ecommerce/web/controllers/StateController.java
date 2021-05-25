package com.raggerbreak.ecommerce.web.controllers;

import com.raggerbreak.ecommerce.domain.State;
import com.raggerbreak.ecommerce.services.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/state")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping("/search/countryCode")
    public ResponseEntity<List<State>> getAllByCountryCode(@RequestParam("code") String code) {
        return new ResponseEntity<>(stateService.getAllByCountry(code), HttpStatus.OK);
    }
}
