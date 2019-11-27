package com.schooling.service;

import com.schooling.entity.Country;
import com.schooling.repository.CountryRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService
{
    private final CountryRespository countryRespository;

    public List<Country> findAll() {
        return countryRespository.findAll();
    }

    public Optional<Country> findByCode(String code) {
        return countryRespository.findByCode(code);
    }

    public Country save(Country country) {
        return countryRespository.save(country);
    }

    public void deleteByCode(String code) {
        countryRespository.deleteByCode(code);
    }
}
