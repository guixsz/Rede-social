package com.guilhermesantana.rede_social.dtos;

import java.time.LocalDate;
import java.util.UUID;

public record UserDto(UUID id, String name, String cpf, LocalDate date, String email, String password) {
}
