package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/**
 * Dados recebidos para criação ou atualização de um plano de assinatura.
 */
@Schema(description = "Dados de um plano de assinatura.")
public record SubscriptionPlanRequest(
        @Schema(description = "Nome do plano.", example = "Pingado Clássico") String name,
        @Schema(description = "Descrição do plano.") String description,
        @Schema(description = "Preço do plano.", example = "42.90") BigDecimal price,
        @Schema(description = "Periodicidade da cobrança.", example = "MENSAL") String periodicity
) {
}
