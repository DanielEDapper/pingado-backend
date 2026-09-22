package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados recebidos para criação ou atualização de uma seleção mensal.
 */
@Schema(description = "Dados de uma seleção mensal de café.")
public record MonthSelectionRequest(
        @Schema(description = "Mês da seleção, de 1 a 12.", example = "9") Integer month,
        @Schema(description = "Ano da seleção.", example = "2026") Integer year,
        @Schema(description = "Título da seleção.", example = "Café de Setembro") String title,
        @Schema(description = "Descrição da seleção.") String description) {
}
