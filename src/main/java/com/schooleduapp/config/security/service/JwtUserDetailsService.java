package com.schooleduapp.config.security.service;

import com.schooleduapp.dto.model.UserDTO;
import com.schooleduapp.entity.User;
import com.schooleduapp.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRespository userRespository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
		User user = userRespository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}

		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getUserRole().name()));

		return new org.springframework.security.core.userdetails
				.User(user.getEmail(), user.getPassword(), authorities);
	}

	public User save(UserDTO userDTO) {
		User newUser = new User();
		newUser.setName(userDTO.getName());
		newUser.setSurname(userDTO.getSurname());
		newUser.setGender(userDTO.getGender());
		newUser.setBirthdate(userDTO.getBirthdate());
		newUser.setCountry(userDTO.getCountry()); //TODO Salvar so a Sigla?
		newUser.setEmail(userDTO.getEmail());
		newUser.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		newUser.setUserRole(userDTO.getUserRole());
		return userRespository.save(newUser);
	}
}