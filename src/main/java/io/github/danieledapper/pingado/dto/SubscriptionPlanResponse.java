package io.github.danieledapper.pingado.dto;

import java.math.BigDecimal;

public record SubscriptionPlanResponse(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String periodicity
) {
}