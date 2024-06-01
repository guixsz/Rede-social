package com.guilhermesantana.rede_social.service;

import com.guilhermesantana.rede_social.domain.Post;
import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.PostDto;
import com.guilhermesantana.rede_social.repositories.PostRepository;

import com.guilhermesantana.rede_social.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

        user.setPostsNumbers(user.getPost().size() + 1);
        Post newPost = new Post(data);
        newPost.setUser(user);
        newPost.setDate(LocalDateTime.now());
        this.postRepository.save(newPost);
        return newPost;
    }

    public List<Post> findAll(){
        List<Post> listPost = this.postRepository.findAll();
        return listPost;
    }

    public List<Post> findPostsById(UUID id) throws Exception{
        List<Post> postList = postRepository.findPostsByUserId(id).orElseThrow(() -> new Exception("Postagens não existentes"));
        return postList;
    }
}
