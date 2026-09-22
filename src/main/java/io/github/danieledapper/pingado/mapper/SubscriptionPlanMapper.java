package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.dto.SubscriptionPlanResponse;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;

/**
 * Conversor entre a entidade SubscriptionPlan e seus DTOs.
 */
public final class SubscriptionPlanMapper {

    private SubscriptionPlanMapper() {
    }

    /**
     * Converte um request em entidade.
     *
     * @param request dados recebidos pela API
     * @return entidade SubscriptionPlan
     */
    public static SubscriptionPlan toEntity(SubscriptionPlanRequest request) {
        return new SubscriptionPlan(null, request.name(), request.description(), request.price(), request.periodicity());
    }

    /**
     * Converte uma entidade em resposta.
     *
     * @param plan entidade de plano
     * @return DTO de resposta
     */
    public static SubscriptionPlanResponse toResponse(SubscriptionPlan plan) {
        return new SubscriptionPlanResponse(plan.getId(), plan.getName(), plan.getDescription(),
                plan.getPrice(), plan.getPeriodicity());
    }
}
