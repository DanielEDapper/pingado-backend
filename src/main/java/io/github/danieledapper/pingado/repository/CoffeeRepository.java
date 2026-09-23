package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long>
{
    List<Coffee> findByMonthlySelectionMonthAndMonthlySelectionYear(
            int month,
            int year
    );
}
