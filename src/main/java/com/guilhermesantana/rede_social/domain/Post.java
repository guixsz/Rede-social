package com.guilhermesantana.rede_social.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guilhermesantana.rede_social.dtos.PostDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String content;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Post() {
    }

    public Post(PostDto data){
        this.id = data.id();
        this.content = data.content();
        this.date = data.date();
        this.user = data.user();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
