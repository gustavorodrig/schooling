package com.schooleduapp.controller;

import com.schooleduapp.entity.Country;
import com.schooleduapp.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/countries")
@Slf4j
@RequiredArgsConstructor
public class CountryController
{
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Country> findByCode(@PathVariable String code) {
        Optional<Country> stock = countryService.findByCode(code);
        if (!stock.isPresent()) {
            log.error("Code " + code + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Country country) {
        return ResponseEntity.ok(countryService.save(country));
    }


    @PutMapping("/{code}")
    public ResponseEntity<Country> update(@PathVariable String code, @Valid @RequestBody Country country) {
        if (!countryService.findByCode(code).isPresent()) {
            log.error("Code " + code + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(countryService.save(country));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable String code) {
        if (!countryService.findByCode(code).isPresent()) {
            log.error("Code " + code + " is not existed");
            ResponseEntity.badRequest().build();
        }
        countryService.deleteByCode(code);
        return ResponseEntity.ok().build();
    }
}
