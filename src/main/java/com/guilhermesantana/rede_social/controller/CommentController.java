package com.guilhermesantana.rede_social.controller;

import com.guilhermesantana.rede_social.domain.Comment;
import com.guilhermesantana.rede_social.dtos.CommentDto;
import com.guilhermesantana.rede_social.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/{userid}/{postid}")
    public ResponseEntity<CommentDto>  createComment(@PathVariable("userid")UUID userId, @PathVariable("postid") UUID postId, @RequestBody CommentDto data) throws Exception{
        CommentDto newComment = this.commentService.createComment(userId, postId, data);
        return new ResponseEntity<>(newComment, HttpStatus.CREATED);
    }
}
