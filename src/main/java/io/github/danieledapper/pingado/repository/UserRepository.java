package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void update(Long id, User user);
}