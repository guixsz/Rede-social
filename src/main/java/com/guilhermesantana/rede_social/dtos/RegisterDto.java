package com.guilhermesantana.rede_social.dtos;

import com.guilhermesantana.rede_social.domain.UserSecurity.UserRole;

public record RegisterDto(String login, String password, UserRole role){
}
