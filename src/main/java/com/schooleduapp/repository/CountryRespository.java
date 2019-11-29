package com.schooleduapp.repository;

import com.schooleduapp.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRespository extends JpaRepository<Country, String> {

    Optional<Country> findByCode(String code);

    void deleteByCode(String code);

}
