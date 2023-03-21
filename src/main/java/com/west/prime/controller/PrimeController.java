package com.west.prime.controller;

import com.west.prime.dto.AlgorithmType;
import com.west.prime.dto.Prime;
import com.west.prime.service.CalculatePrimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/primes")
public class PrimeController {
    private final CalculatePrimeService service;

    @GetMapping(value = "/{number}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Prime findPrime(@PathVariable int number,
                           @RequestParam(required = false, defaultValue = "BRUTE_FORCE")
                           AlgorithmType algorithmType) {
        return service.getPrimes(number, algorithmType);
    }
}
