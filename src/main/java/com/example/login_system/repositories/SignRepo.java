package com.example.login_system.repositories;

import com.example.login_system.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignRepo extends JpaRepository<User,Integer> {

    static Optional<User> findByUsername(String username);
}
