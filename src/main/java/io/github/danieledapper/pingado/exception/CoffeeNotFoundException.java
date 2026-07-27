package io.github.danieledapper.pingado.exception;

public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(Long id) {
        super("Coffee not found with id: "+id);
    }
}
