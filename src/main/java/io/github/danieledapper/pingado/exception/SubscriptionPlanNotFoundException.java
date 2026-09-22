package io.github.danieledapper.pingado.exception;


public class SubscriptionPlanNotFoundException
        extends RecourceNotFoundException {

    public SubscriptionPlanNotFoundException(Long id) {
        super("Subscription plan not found with id: " + id);
    }
}