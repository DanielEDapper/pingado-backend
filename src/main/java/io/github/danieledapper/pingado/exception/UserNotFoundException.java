package io.github.danieledapper.pingado.exception;


public class UserNotFoundException
        extends RecourceNotFoundException {

    public UserNotFoundException(Long id) {
        super("User not found with id: " + id);
    }
}