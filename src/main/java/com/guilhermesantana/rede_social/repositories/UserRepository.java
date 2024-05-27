package com.guilhermesantana.rede_social.repositories;

import com.guilhermesantana.rede_social.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserById(UUID id);
}
