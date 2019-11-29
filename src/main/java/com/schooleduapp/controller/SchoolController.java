package com.schooleduapp.controller;

import com.schooleduapp.entity.School;
import com.schooleduapp.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/schools")
@Slf4j
@RequiredArgsConstructor
public class SchoolController
{
    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> findAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> findByCode(@PathVariable Long id) {
        Optional<School> school = schoolService.findById(id);
        if (!school.isPresent()) {
            log.error("School " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(school.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody School course) {
        return ResponseEntity.ok(schoolService.save(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> update(@PathVariable Long id, @Valid @RequestBody School school) {
        if (!schoolService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(schoolService.save(school));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!schoolService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        schoolService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
