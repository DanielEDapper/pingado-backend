package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso payment não é encontrado.
 */
public class PaymentNotFoundException extends ResourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public PaymentNotFoundException(Long id) {
        super("Payment not found with id: " + id);
    }
}
