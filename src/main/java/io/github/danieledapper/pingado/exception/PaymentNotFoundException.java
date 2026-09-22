package io.github.danieledapper.pingado.exception;

public class PaymentNotFoundException
        extends RecourceNotFoundException {

    public PaymentNotFoundException(Long id) {
        super("Payment not found with id: " + id);
    }
}