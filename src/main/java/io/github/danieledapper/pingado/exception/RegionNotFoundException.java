package io.github.danieledapper.pingado.exception;

public class RegionNotFoundException extends ResourceNotFoundException {
    public RegionNotFoundException(Long id) {
        super("Region not found with ID: "+id);
    }
}
