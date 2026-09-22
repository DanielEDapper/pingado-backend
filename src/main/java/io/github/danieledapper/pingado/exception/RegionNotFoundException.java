package io.github.danieledapper.pingado.exception;


public class RegionNotFoundException
        extends RecourceNotFoundException {

    public RegionNotFoundException(Long id) {
        super("Region not found with id: " + id);
    }
}