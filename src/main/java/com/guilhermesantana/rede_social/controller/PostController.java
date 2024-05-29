package com.guilhermesantana.rede_social.controller;

import com.guilhermesantana.rede_social.domain.Post;
import com.guilhermesantana.rede_social.dtos.PostDto;
import com.guilhermesantana.rede_social.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Post> createPost(@PathVariable("id") UUID id, @RequestBody PostDto data) throws Exception{
        Post newPost = this.postService.createPost(id, data);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        List<Post> listPost = this.postService.findAll();
        return new ResponseEntity<>(listPost, HttpStatus.OK);
    }

}
