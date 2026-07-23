package io.github.danieledapper.pingado.exception;

public class RegionNotFoundException extends RuntimeException {
    public RegionNotFoundException(Long id) {
        super("Region not found with ID: "+id);
    }
}
