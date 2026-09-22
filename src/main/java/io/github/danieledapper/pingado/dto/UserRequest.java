package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Dados recebidos para criação ou atualização de um usuário.
 */
@Schema(description = "Dados necessários para criar ou atualizar um usuário.")
public record UserRequest(
        @Schema(description = "Nome do usuário.", example = "Daniel Dapper") String name,
        @Schema(description = "E-mail único do usuário.", example = "daniel@example.com") String email,
        @Schema(description = "Senha do usuário.", example = "senha-segura") String password,
        @Schema(description = "Papel do usuário.", example = "USER", allowableValues = {"USER", "ADMIN"}) String role
) {
}
