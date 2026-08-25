package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.MonthlySelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthSelectionRepository extends JpaRepository<MonthlySelection, Long> {
    void update(Long id, MonthlySelection monthlySelection);
}
