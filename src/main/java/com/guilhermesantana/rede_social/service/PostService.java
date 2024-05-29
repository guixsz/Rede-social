package com.guilhermesantana.rede_social.service;

import com.guilhermesantana.rede_social.domain.Post;
import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.PostDto;
import com.guilhermesantana.rede_social.repositories.PostRepository;

import com.guilhermesantana.rede_social.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class PostService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(UUID id, PostDto data) throws Exception{
        User user = this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));

        Post newPost = new Post(data);
        newPost.setUser(user);
        newPost.setDate(LocalDateTime.now());
        this.postRepository.save(newPost);
        return newPost;
    }
}
