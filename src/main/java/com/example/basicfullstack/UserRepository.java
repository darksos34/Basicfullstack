package com.example.basicfullstack;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByPublished(boolean published);
    List<User> findByTitleContaining(String title);

    User findByEmail(String email);
}