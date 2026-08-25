package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
