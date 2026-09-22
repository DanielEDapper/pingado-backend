package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

/**
 * Dados retornados pela API para uma assinatura.
 */
@Schema(description = "Representação de uma assinatura retornada pela API.")
public record UserSubscriptionResponse(
        @Schema(description = "ID da assinatura.", example = "1") Long id,
        @Schema(description = "Data de início.", example = "2026-09-22") LocalDate startDate,
        @Schema(description = "Data de término.", example = "2027-09-22", nullable = true) LocalDate endDate,
        @Schema(description = "Status da assinatura.", example = "ATIVA") String status,
        @Schema(description = "ID do usuário.", example = "1") Long userId,
        @Schema(description = "ID do plano contratado.", example = "1") Long subscriptionPlanId
) {
}
