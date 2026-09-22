package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository
        extends JpaRepository<UserSubscription, Long> {
}