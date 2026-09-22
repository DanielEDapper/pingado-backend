package io.github.danieledapper.pingado.dto;

import java.time.LocalDate;

public record UserSubscriptionRequest(
        LocalDate startDate,
        LocalDate endDate,
        String status,
        Long userId,
        Long subscriptionPlanId
) {
}