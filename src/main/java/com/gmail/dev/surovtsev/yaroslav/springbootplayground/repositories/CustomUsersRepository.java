package com.gmail.dev.surovtsev.yaroslav.springbootplayground.repositories;

import com.gmail.dev.surovtsev.yaroslav.springbootplayground.models.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomUsersRepository extends JpaRepository<CustomUser, Long> {
    Optional<CustomUser> findByUsername(String username);
}
