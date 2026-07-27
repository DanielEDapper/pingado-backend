package io.github.danieledapper.pingado.dto;

public record CoffeeResponse(Long id, String name, String description, String sensoryNotes, String image, Long regionId, Long monthlySelectionId) {
}
