package com.schooleduapp.controller.v1;

import com.schooleduapp.config.PropertiesConfig;
import com.schooleduapp.dto.model.CityDTO;
import com.schooleduapp.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/cities")
@Slf4j
@RequiredArgsConstructor
public class CityController
{
    private final CityService cityService;

    private final PropertiesConfig propertiesConfig;

    @GetMapping
    public ResponseEntity<Set<CityDTO>> findAll() {
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findByCode(@PathVariable Long id) {
        CityDTO cityDTO = cityService.findById(id);
        return ResponseEntity.ok(cityDTO);
    }

    @PostMapping
    public ResponseEntity<CityDTO> create(@Valid @RequestBody CityDTO city) {
        return ResponseEntity.ok(cityService.save(city));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> update(@PathVariable Long id, @Valid @RequestBody CityDTO city) {
        cityService.findById(id);
        return ResponseEntity.ok(cityService.save(city));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        cityService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
