package com.schooleduapp.controller.v1;

import com.schooleduapp.dto.model.CountryDTO;
import com.schooleduapp.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.TreeSet;


@RestController
@RequestMapping("/api/v1/countries")
@Slf4j
@RequiredArgsConstructor
public class CountryController
{
    private final CountryService countryService;

    @GetMapping
    public ResponseEntity<TreeSet<CountryDTO>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<CountryDTO> findByCode(@PathVariable String code) {
        CountryDTO countryDTO = countryService.findByCode(code);
        return ResponseEntity.ok(countryDTO);
    }

    @PostMapping
    public ResponseEntity<CountryDTO> create(@Valid @RequestBody CountryDTO countryDTO) {
        return ResponseEntity.ok(countryService.save(countryDTO));
    }

    @PutMapping("/{code}")
    public ResponseEntity<CountryDTO> update(@PathVariable String code, @Valid @RequestBody CountryDTO countryDTO) {
        countryService.findByCode(code);
        return ResponseEntity.ok(countryService.save(countryDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity delete(@PathVariable String code) {
        countryService.deleteByCode(code);
        return ResponseEntity.ok().build();
    }
}
