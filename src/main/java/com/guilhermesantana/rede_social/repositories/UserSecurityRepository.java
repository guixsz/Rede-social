package com.guilhermesantana.rede_social.repositories;

import com.guilhermesantana.rede_social.domain.UserSecurity.UserSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserSecurityRepository extends JpaRepository<UserSecurity, String> {

    UserDetails findByLogin(String login);
}
