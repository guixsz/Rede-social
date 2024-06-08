package com.guilhermesantana.rede_social.controller;

import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.domain.UserSecurity.UserSecurity;
import com.guilhermesantana.rede_social.dtos.AuthenticationDto;
import com.guilhermesantana.rede_social.dtos.LoginResponseDto;
import com.guilhermesantana.rede_social.dtos.RegisterDto;
import com.guilhermesantana.rede_social.infra.security.TokenService;
import com.guilhermesantana.rede_social.repositories.UserSecurityRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSecurityRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserSecurity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserSecurity newUser = new UserSecurity(data.login(), encryptedPassword, data.role());

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }

}
