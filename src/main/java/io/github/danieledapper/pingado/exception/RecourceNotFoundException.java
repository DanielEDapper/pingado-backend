package io.github.danieledapper.pingado.exception;

/**
 * Exceção base para recursos solicitados que não foram encontrados.
 *
 * <p>O nome da classe é mantido por compatibilidade com o projeto atual.</p>
 */
public class RecourceNotFoundException extends RuntimeException {

    /**
     * Cria a exceção com uma mensagem descritiva.
     *
     * @param message mensagem do erro
     */
    public RecourceNotFoundException(String message) {
        super(message);
    }
}
