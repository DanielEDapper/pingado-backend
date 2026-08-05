package io.github.danieledapper.pingado.exception;

public class CoffeeNotFoundException extends ResourceNotFoundException {
    public CoffeeNotFoundException(Long id) {
        super("Coffee not found with id: "+id);
    }
}
