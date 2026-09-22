package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository
        extends JpaRepository<SubscriptionPlan, Long> {
}