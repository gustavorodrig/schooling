package com.schooleduapp.dto.model;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CityDTO implements Comparable<CityDTO> {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String countryCode;

    @Override
    public int compareTo(CityDTO o) {
        return 0;
    }
}
