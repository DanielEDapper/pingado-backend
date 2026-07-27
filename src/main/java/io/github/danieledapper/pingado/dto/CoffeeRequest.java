package io.github.danieledapper.pingado.dto;

public record CoffeeRequest(String name, String description, String sensoryNotes, String image, Long regionId, Long monthlySelectionId) {
}
