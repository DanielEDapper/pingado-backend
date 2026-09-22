package io.github.danieledapper.pingado.exception;

public class UserSubscriptionNotFoundException
        extends ResourceNotFoundException {

    public UserSubscriptionNotFoundException(Long id) {
        super("User subscription not found with id: " + id);
    }
}
