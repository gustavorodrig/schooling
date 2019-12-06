package com.schooleduapp.dto.model;

import com.schooleduapp.config.security.model.UserRole;
import com.schooleduapp.entity.Country;
import com.schooleduapp.entity.type.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO implements Comparable<UserDTO> {

    private String name;

    private String surname;

    private Date birthdate;

    private Gender gender;

    private String email;

    private String password;

    private Country country;

    private UserRole userRole;

    @Override
    public int compareTo(UserDTO o) {
        return 0;
    }
}