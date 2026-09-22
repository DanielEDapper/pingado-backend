package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados retornados pela API para uma região produtora.
 */
@Schema(description = "Representação de uma região produtora retornada pela API.")
public record RegionResponse(
        @Schema(description = "ID da região.", example = "1") Long id,
        @Schema(description = "Nome da região.", example = "Serra da Mantiqueira") String name,
        @Schema(description = "Estado brasileiro.", example = "MG") String state,
        @Schema(description = "Descrição da região.") String description,
        @Schema(description = "Altitude média em metros.", example = "1200") Integer avarageAltitude,
        @Schema(description = "Perfil sensorial associado à região.") String sensoryProfile) {
}
