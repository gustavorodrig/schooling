package com.schooling.repository;

import com.schooling.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRespository extends JpaRepository<City, Long> {

}
