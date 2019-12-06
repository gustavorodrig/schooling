package com.schooleduapp.service;

import com.schooleduapp.dto.model.CountryDTO;
import com.schooleduapp.entity.Country;
import com.schooleduapp.exception.EntityCustomException;
import com.schooleduapp.repository.CountryRespository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.schooleduapp.exception.EntityType.COUNTRY;
import static com.schooleduapp.exception.ExceptionType.ENTITY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CountryService
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final CountryRespository countryRespository;

    public TreeSet<CountryDTO> findAll() {
        return countryRespository.findAll()
                .stream()
                .map(country -> modelMapper.map(country, CountryDTO.class))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public CountryDTO findByCode(String code) {
        Optional<Country> country = countryRespository.findByCode(code);
        if (country.isPresent()) {
            return modelMapper.map(country.get(), CountryDTO.class);
        }
       throw EntityCustomException.throwCustomException(COUNTRY, ENTITY_NOT_FOUND, code);
    }

    public CountryDTO save(CountryDTO countryDTO) {
        Country country = modelMapper.map(countryDTO, Country.class);
        return modelMapper.map(countryRespository.save(country), CountryDTO.class);
    }

    public void deleteByCode(String code) {
        this.findByCode(code);
        countryRespository.deleteByCode(code);
    }
}
