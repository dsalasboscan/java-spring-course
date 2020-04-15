package com.eduit.spring.service;

import com.eduit.spring.model.Role;
import com.eduit.spring.model.User;
import com.eduit.spring.model.UserDto;
import com.eduit.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    public UserServiceImpl(BCryptPasswordEncoder passwordEncoder, UserRepository userRepository,
                           @Qualifier("userDetailTask") UserDetailsService userDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByEmail(String email) {
        return userDetailsService.loadUserByUsername(email);
    }

    @Override
    @Transactional
    public void save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));
        Role role = new Role(userDto.getRole());

        user.addRole(role);

        userRepository.save(user);
    }

    @Override
    @Transactional
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
            .map(
                user -> {
                    UserDto userDto = new UserDto();
                    user.setId(user.getId());
                    user.setEmail(user.getEmail());
                    return userDto;
                }
            ).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
