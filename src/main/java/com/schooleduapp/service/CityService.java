package com.schooleduapp.service;

import com.schooleduapp.dto.model.CityDTO;
import com.schooleduapp.entity.City;
import com.schooleduapp.exception.EntityCustomException;
import com.schooleduapp.repository.CityRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.schooleduapp.exception.EntityType.CITY;
import static com.schooleduapp.exception.ExceptionType.ENTITY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CityService
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final CityRespository cityRespository;

    public Set<CityDTO> findAll() {
        return cityRespository.findAll()
                .stream()
                .map(city -> modelMapper.map(city, CityDTO.class))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public CityDTO findById(Long id){
        Optional<City> city = cityRespository.findById(id);
        if (city.isPresent()) {
            return modelMapper.map(city.get(), CityDTO.class);
        }
        throw EntityCustomException.throwCustomException(CITY, ENTITY_NOT_FOUND, id);
    }

    public CityDTO save(CityDTO cityDTO) {
        City city = modelMapper.map(cityDTO, City.class);
        return modelMapper.map(cityRespository.save(city), CityDTO.class);
    }

    public void deleteById(Long id) {
        this.findById(id);
        cityRespository.deleteById(id);
    }
}
