package com.schooling.repository;

import com.schooling.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRespository extends JpaRepository<School, Long> {

}
