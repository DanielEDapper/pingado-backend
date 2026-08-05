package io.github.danieledapper.pingado.error;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timestamp)
{
}
