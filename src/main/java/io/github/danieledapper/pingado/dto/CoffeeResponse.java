package io.github.danieledapper.pingado.dto;

import io.github.danieledapper.pingado.entity.Region;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados retornados pela API para um café.
 */
@Schema(description = "Representação de um café retornada pela API.")
public record CoffeeResponse(
        @Schema(description = "ID do café.", example = "1") Long id,
        @Schema(description = "Nome do café.", example = "Catuaí Amarelo") String name,
        @Schema(description = "Descrição do café.") String description,
        @Schema(description = "Notas sensoriais.") String sensoryNotes,
        @Schema(description = "URL ou referência da imagem.") String image,
        @Schema(description = "Nome da região produtora.", example = "1") Region region,
        @Schema(description = "ID da seleção mensal.", example = "1", nullable = true) Long monthlySelectionId) {
}
