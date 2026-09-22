package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados públicos retornados pela API para um usuário.
 *
 * <p>A senha propositalmente não faz parte desta representação.</p>
 */
@Schema(description = "Representação pública de um usuário. A senha nunca é retornada.")
public record UserResponse(
        @Schema(description = "ID do usuário.", example = "1") Long id,
        @Schema(description = "Nome do usuário.", example = "Daniel Dapper") String name,
        @Schema(description = "E-mail do usuário.", example = "daniel@example.com") String email,
        @Schema(description = "Papel do usuário.", example = "USER") String role
) {
}
