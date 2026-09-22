package io.github.danieledapper.pingado.dto;

public record UserResponse(
        Long id,
        String name,
        String email,
        String role
) {
}