package com.schooleduapp.repository;

import com.schooleduapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
