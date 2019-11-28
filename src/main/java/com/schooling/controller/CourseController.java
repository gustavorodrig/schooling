package com.schooling.controller;

import com.schooling.entity.Course;
import com.schooling.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/courses")
@Slf4j
@RequiredArgsConstructor
public class CourseController
{
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findByCode(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        if (!course.isPresent()) {
            log.error("Course " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(course.get());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Course course) {
        return ResponseEntity.ok(courseService.save(course));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @Valid @RequestBody Course course) {
        if (!courseService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(courseService.save(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!courseService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
