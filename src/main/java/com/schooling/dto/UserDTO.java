package com.schooling.dto;

import com.schooling.config.security.model.UserRole;
import com.schooling.entity.Country;
import com.schooling.entity.type.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO
{
	private String name;
	private String surname;
	private Date birthdate;
	private Gender gender;
	private String email;
	private String password;
	private Country country;
	private UserRole userRole;
}