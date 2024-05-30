package com.guilhermesantana.rede_social.controller;

import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.UserDto;
import com.guilhermesantana.rede_social.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
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

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = this.userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") UUID id) throws Exception{
        User user = this.userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
