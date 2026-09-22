package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

/**
 * Dados recebidos para criação ou atualização de uma assinatura.
 */
@Schema(description = "Dados de uma assinatura vinculada a um usuário e a um plano.")
public record UserSubscriptionRequest(
        @Schema(description = "Data de início.", example = "2026-09-22") LocalDate startDate,
        @Schema(description = "Data de término, quando houver.", example = "2027-09-22", nullable = true) LocalDate endDate,
        @Schema(description = "Status da assinatura.", example = "ATIVA", allowableValues = {"ATIVA", "CANCELADA", "PAUSADA", "EXPIRADA"}) String status,
        @Schema(description = "ID do usuário proprietário.", example = "1") Long userId,
        @Schema(description = "ID do plano contratado.", example = "1") Long subscriptionPlanId
) {
}
