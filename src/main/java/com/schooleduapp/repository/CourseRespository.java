package com.schooleduapp.repository;

import com.schooleduapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRespository extends JpaRepository<Course, Long> {

}
