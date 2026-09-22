package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando um e-mail já está associado a outro usuário.
 */
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Cria a exceção para o e-mail em conflito.
     *
     * @param email e-mail que já está cadastrado
     */
    public EmailAlreadyExistsException(String email) {
        super("Email already in use: " + email);
    }
}
