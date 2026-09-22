package io.github.danieledapper.pingado.dto;

import java.math.BigDecimal;

public record SubscriptionPlanRequest(
        String name,
        String description,
        BigDecimal price,
        String periodicity
) {
}