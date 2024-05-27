package com.guilhermesantana.rede_social.controller;

import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.UserDto;
import com.guilhermesantana.rede_social.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto data){
        User newUser = this.userService.createUser(data);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
