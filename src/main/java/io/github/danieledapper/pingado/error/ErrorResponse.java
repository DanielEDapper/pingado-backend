package io.github.danieledapper.pingado.error;

import java.time.LocalDateTime;

/**
 * Estrutura padronizada de resposta para erros HTTP da API.
 *
 * @param status código HTTP do erro
 * @param message mensagem apresentada ao consumidor da API
 * @param timestamp momento em que o erro foi processado
 */
public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp) {
}
