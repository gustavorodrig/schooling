package com.schooling.entity;

import com.schooling.entity.audit.Auditable;
import com.schooling.entity.type.*;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Course extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CourseType type;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private CoursePeriod period;

    @Enumerated(EnumType.STRING)
    private CourseDuration duration;

    private Date startFrom;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "school_id")
    private School school;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private CourseStatus status;
}
