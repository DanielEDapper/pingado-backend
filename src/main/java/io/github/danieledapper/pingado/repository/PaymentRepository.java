package io.github.danieledapper.pingado.repository;

import io.github.danieledapper.pingado.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {
}