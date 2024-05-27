package com.guilhermesantana.rede_social.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserDto(UUID id, String name, String cpf, LocalDateTime date, String email, String password) {
}
