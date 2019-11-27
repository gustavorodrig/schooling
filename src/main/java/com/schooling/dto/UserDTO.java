package com.schooling.dto;

import com.schooling.config.security.model.UserRole;
import lombok.Data;

@Data
public class UserDTO
{
	private String email;
	private String password;
	private UserRole userRole;
}