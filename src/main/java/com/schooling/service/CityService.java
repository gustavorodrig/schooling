package com.schooling.service;

import com.schooling.entity.City;
import com.schooling.repository.CityRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService
{
    private final CityRespository cityRespository;

    public List<City> findAll() {
        return cityRespository.findAll();
    }

    public Optional<City> findById(Long id) {
        return cityRespository.findById(id);
    }

    public City save(City city) {
        return cityRespository.save(city);
    }

    public void deleteById(Long id) {
        cityRespository.deleteById(id);
    }
}
