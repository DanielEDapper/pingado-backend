package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso coffee não é encontrado.
 */
public class CoffeeNotFoundException extends ResourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public CoffeeNotFoundException(Long id) {
        super("Coffee not found with id: " + id);
    }
}
