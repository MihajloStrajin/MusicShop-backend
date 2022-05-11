package com.example.musicshop.repository;

import com.example.musicshop.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByName(String organizer);

    boolean existsByName(String name);
}
