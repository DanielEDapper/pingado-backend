package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados recebidos para criação ou atualização de um café.
 */
@Schema(description = "Dados necessários para criar ou atualizar um café.")
public record CoffeeRequest(
        @Schema(description = "Nome do café.", example = "Catuaí Amarelo") String name,
        @Schema(description = "Descrição do café.", example = "Café especial de torra média.") String description,
        @Schema(description = "Notas sensoriais.", example = "Chocolate, caramelo e frutas amarelas.") String sensoryNotes,
        @Schema(description = "URL ou referência da imagem.", example = "https://example.com/cafe.jpg") String image,
        @Schema(description = "ID da região produtora.", example = "1") Long regionId,
        @Schema(description = "ID da seleção mensal associada. Pode ser nulo.", example = "1", nullable = true) Long monthlySelectionId) {
}
