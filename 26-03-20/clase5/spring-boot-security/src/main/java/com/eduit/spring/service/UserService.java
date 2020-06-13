package com.eduit.spring.service;

import com.eduit.spring.model.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    UserDetails loadUserByEmail(String email);

    void save(UserDto userDto);

    List<UserDto> findAll();

    void deleteById(Long id);
}
