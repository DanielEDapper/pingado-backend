package io.github.danieledapper.pingado.exception;

/**
 * Exceção para informações de usuário consideradas inválidas pela regra de negócio.
 */
public class UserInformationsIncorrectException extends RuntimeException {

    /**
     * Cria a exceção com uma mensagem descritiva.
     *
     * @param message mensagem do erro
     */
    public UserInformationsIncorrectException(String message) {
        super(message);
    }
}
