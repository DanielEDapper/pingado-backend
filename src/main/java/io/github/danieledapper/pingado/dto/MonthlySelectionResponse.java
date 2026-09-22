package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados retornados pela API para uma seleção mensal.
 */
@Schema(description = "Representação de uma seleção mensal retornada pela API.")
public record MonthlySelectionResponse(
        @Schema(description = "ID da seleção.", example = "1") Long id,
        @Schema(description = "Mês da seleção.", example = "9") Integer month,
        @Schema(description = "Ano da seleção.", example = "2026") Integer year,
        @Schema(description = "Título da seleção.", example = "Café de Setembro") String title,
        @Schema(description = "Descrição da seleção.") String description) {
}
