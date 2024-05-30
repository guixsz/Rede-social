package com.guilhermesantana.rede_social.service;

import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.UserDto;
import com.guilhermesantana.rede_social.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public List<User> findAll(){
        List<User> listUser = this.userRepository.findAll();
        return listUser;
    }

    public User findById(UUID id) throws Exception{
        User userList = this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Not found user"));
        return userList;
    }
}
