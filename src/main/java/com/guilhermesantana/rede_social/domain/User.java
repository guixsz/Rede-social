package com.guilhermesantana.rede_social.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guilhermesantana.rede_social.dtos.UserDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String cpf;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String email;

    private String password;

    public User() {}

    public User(String name, String cpf, LocalDate date, String email, String password) {
        this.name = name;
        this.cpf = cpf;
        this.date = date;
        this.email = email;
        this.password = password;
    }

    public User(UserDto data){
        this.name = data.name();
        this.cpf = data.cpf();
        this.date = data.date();
        this.email = data.email();
        this.password = data.password();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
