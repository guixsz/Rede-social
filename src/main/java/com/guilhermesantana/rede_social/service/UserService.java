package com.guilhermesantana.rede_social.service;

import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.UserDto;
import com.guilhermesantana.rede_social.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(UserDto data){
        User newUser = new User(data);
        this.userRepository.save(newUser);
        return newUser;
    }
}
