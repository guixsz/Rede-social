package com.guilhermesantana.rede_social.repositories;

import com.guilhermesantana.rede_social.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    Optional<Comment> findCommentById(UUID id);
}
