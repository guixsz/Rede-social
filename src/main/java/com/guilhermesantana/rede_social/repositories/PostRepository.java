package com.guilhermesantana.rede_social.repositories;

import com.guilhermesantana.rede_social.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

    Optional<Post> findPostById(UUID id);

    Optional<List<Post>> findPostsByUserId(UUID id);
}
