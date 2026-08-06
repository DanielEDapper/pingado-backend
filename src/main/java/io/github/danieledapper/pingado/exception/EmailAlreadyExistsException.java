package io.github.danieledapper.pingado.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(Long id) {
        super("User not found with id: "+id);
    }
}
