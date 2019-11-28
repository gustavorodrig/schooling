package com.schooling.repository;

import com.schooling.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Course, Long> {

}
