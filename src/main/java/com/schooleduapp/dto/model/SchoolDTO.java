package com.schooleduapp.dto.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SchoolDTO implements Comparable<SchoolDTO> {
    private Long id;

    private String name;

    private String address;

    private Set<CourseDTO> courses = new HashSet<>();

    private CityDTO city;

    private UserDTO user;

    public void addCourse(CourseDTO course) {
        courses.add(course);
    }

    @Override
    public int compareTo(SchoolDTO o) {
        return 0;
    }
}
