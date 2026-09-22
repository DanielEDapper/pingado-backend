package io.github.danieledapper.pingado.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentRequest(
        LocalDate paymentDate,
        BigDecimal amount,
        String paymentMethod,
        String status,
        Long userSubscriptionId
) {
}