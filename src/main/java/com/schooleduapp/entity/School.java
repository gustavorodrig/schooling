package com.schooleduapp.entity;

import com.schooleduapp.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class School extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "school")
    private Set<Course> courses = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "cityId", nullable = true)
    private City city;

    @OneToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    public void addCourse(Course course){
        courses.add(course);
    }
}
