package com.guilhermesantana.rede_social.service;

import com.guilhermesantana.rede_social.domain.Comment;
import com.guilhermesantana.rede_social.domain.Post;
import com.guilhermesantana.rede_social.domain.User;
import com.guilhermesantana.rede_social.dtos.CommentDto;
import com.guilhermesantana.rede_social.repositories.CommentRepository;
import com.guilhermesantana.rede_social.repositories.PostRepository;
import com.guilhermesantana.rede_social.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    private UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository, UserRepository userRepository){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public CommentDto createComment(UUID userId, UUID postId, CommentDto data) throws Exception{
        User userComment = this.userRepository.findUserById(userId).orElseThrow(() -> new Exception("Usuário não encontrado"));

        Post postComment = this.postRepository.findPostById(postId).orElseThrow(() -> new Exception("post não encontrado"));


        Comment newComment = new Comment(data);
        newComment.setDate(LocalDateTime.now());
        newComment.setPost(postComment);
        newComment.setUser(userComment);
        this.commentRepository.save(newComment);
        return new CommentDto(newComment.getId(), newComment.getDate(), newComment.getContent(), userId, postId);
    }

    public List<Comment> findCommentByUserId(UUID id) throws Exception{
        List<Comment> listComment = this.commentRepository.findCommentsByUserId(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
        return listComment;
    }

    public List<CommentDto> findAll() throws Exception{
        List<CommentDto> dtoList = this.commentRepository.findAllComments();
        return dtoList;
    }

    public CommentDto findCommentById(UUID id) throws Exception{
        Comment comment = this.commentRepository.findCommentById(id).orElseThrow(() -> new Exception("Comentário não encontrado"));

        UUID postId = comment.getPost().getId();
        UUID userId = comment.getUser().getId();

        return new CommentDto(comment.getId(), comment.getDate(), comment.getContent(), userId, postId);
    }
}
