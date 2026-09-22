package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.dto.SubscriptionPlanResponse;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;

public class SubscriptionPlanMapper {

    private SubscriptionPlanMapper() {
    }

    public static SubscriptionPlan toEntity(
            SubscriptionPlanRequest request
    ) {
        return new SubscriptionPlan(
                null,
                request.name(),
                request.description(),
                request.price(),
                request.periodicity()
        );
    }

    public static SubscriptionPlanResponse toResponse(
            SubscriptionPlan plan
    ) {
        return new SubscriptionPlanResponse(
                plan.getId(),
                plan.getName(),
                plan.getDescription(),
                plan.getPrice(),
                plan.getPeriodicity()
        );
    }
}