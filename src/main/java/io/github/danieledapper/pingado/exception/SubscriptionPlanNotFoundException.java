package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso subscription plan não é encontrado.
 */
public class SubscriptionPlanNotFoundException extends RecourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public SubscriptionPlanNotFoundException(Long id) {
        super("Subscription plan not found with id: " + id);
    }
}
