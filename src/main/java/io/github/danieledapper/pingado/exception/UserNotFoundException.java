package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso user não é encontrado.
 */
public class UserNotFoundException extends ResourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public UserNotFoundException(Long id) {
        super("User not found with id: " + id);
    }
}
