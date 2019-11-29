package com.schooleduapp.service;

import com.schooleduapp.entity.Course;
import com.schooleduapp.repository.CourseRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService
{
    private final CourseRespository courseRespository;

    public List<Course> findAll() {
        return courseRespository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRespository.findById(id);
    }

    public Course save(Course course) {
        return courseRespository.save(course);
    }

    public void deleteById(Long id) {
        courseRespository.deleteById(id);
    }
}
