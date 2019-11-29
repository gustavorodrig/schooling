package com.schooleduapp.repository;

import com.schooleduapp.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRespository extends JpaRepository<School, Long> {

}
