package com.schooleduapp.dto.model;

import com.schooleduapp.entity.type.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseDTO implements Comparable<CourseDTO> {

    private Long id;

    private String name;

    private CourseType type;

    private Language language;

    private CoursePeriod period;

    private CourseDuration duration;

    private Date startFrom;

    private SchoolDTO school;

    private BigDecimal price;

    private CourseStatus status;

    @Override
    public int compareTo(CourseDTO o) {
        return 0;
    }
}
