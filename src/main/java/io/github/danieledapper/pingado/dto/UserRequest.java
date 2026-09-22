package io.github.danieledapper.pingado.dto;

public record UserRequest(
        String name,
        String email,
        String password,
        String role
) {
}