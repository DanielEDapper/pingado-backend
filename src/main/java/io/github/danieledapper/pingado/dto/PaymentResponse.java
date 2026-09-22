package io.github.danieledapper.pingado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentResponse(
        Long id,
        LocalDate paymentDate,
        BigDecimal amount,
        String paymentMethod,
        String status,
        Long userSubscriptionId
) {
}