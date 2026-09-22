package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados recebidos para criação ou atualização de uma região produtora.
 */
@Schema(description = "Dados de uma região produtora de café.")
public record RegionRequest(
        @Schema(description = "Nome da região.", example = "Serra da Mantiqueira") String name,
        @Schema(description = "Estado brasileiro.", example = "MG") String state,
        @Schema(description = "Descrição da região.") String description,
        @Schema(description = "Altitude média em metros.", example = "1200") Integer averageAltitude,
        @Schema(description = "Perfil sensorial associado à região.", example = "Doçura e acidez equilibradas.") String sensoryProfile) {
}
