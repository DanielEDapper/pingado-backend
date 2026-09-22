package io.github.danieledapper.pingado.dto;

import java.time.LocalDate;

public record UserSubscriptionResponse(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        String status,
        Long userId,
        Long subscriptionPlanId
) {
}