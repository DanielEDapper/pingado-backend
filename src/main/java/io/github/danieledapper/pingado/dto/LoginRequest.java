package io.github.danieledapper.pingado.dto;

public record LoginRequest(
        String email,
        String password
) {
}