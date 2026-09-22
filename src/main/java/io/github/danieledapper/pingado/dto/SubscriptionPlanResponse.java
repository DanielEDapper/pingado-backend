package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * Dados retornados pela API para um plano de assinatura.
 */
@Schema(description = "Representação de um plano de assinatura retornada pela API.")
public record SubscriptionPlanResponse(
        @Schema(description = "ID do plano.", example = "1") Long id,
        @Schema(description = "Nome do plano.", example = "Pingado Clássico") String name,
        @Schema(description = "Descrição do plano.") String description,
        @Schema(description = "Preço do plano.", example = "42.90") BigDecimal price,
        @Schema(description = "Periodicidade da cobrança.", example = "MENSAL") String periodicity
) {
}
