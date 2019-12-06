package com.schooleduapp.dto.model;

import lombok.Data;

import java.util.Set;

@Data
public class CountryDTO implements Comparable<CountryDTO> {

    private String code;

    private String name;

    private Set<CityDTO> cities;

    private String continentName;

    @Override
    public int compareTo(CountryDTO o) {
        return 0;
    }
}
