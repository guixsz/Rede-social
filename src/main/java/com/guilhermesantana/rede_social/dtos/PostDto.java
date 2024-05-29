package com.guilhermesantana.rede_social.dtos;

import com.guilhermesantana.rede_social.domain.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostDto(UUID id, String content, LocalDateTime date, User user) {
}
