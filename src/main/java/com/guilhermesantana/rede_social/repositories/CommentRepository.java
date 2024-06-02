package com.guilhermesantana.rede_social.repositories;

import com.guilhermesantana.rede_social.domain.Comment;
import com.guilhermesantana.rede_social.dtos.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {

    Optional<Comment> findCommentById(UUID id);

    Optional<List<Comment>> findCommentsByUserId(UUID userId);

    @Query("SELECT new com.guilhermesantana.rede_social.dtos.CommentDto(c.id, c.date, c.content, c.user.id, c.post.id) FROM Comment c")
    List<CommentDto> findAllComments();
}
