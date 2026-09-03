package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.MonthlySelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlySelectionRepository extends JpaRepository<MonthlySelection, Long> {
    void update(Long id, MonthlySelection monthlySelection);
}
