package com.guilhermesantana.rede_social.dtos;

import com.guilhermesantana.rede_social.domain.Post;
import com.guilhermesantana.rede_social.domain.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentDto(UUID id, LocalDateTime date, String content, UUID user, UUID post) {
}
