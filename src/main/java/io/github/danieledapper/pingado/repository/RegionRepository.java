package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    void update(Long id, Region region);
}
