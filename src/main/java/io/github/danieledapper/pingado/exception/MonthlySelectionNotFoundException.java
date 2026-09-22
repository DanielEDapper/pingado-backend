package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso monthly selection não é encontrado.
 */
public class MonthlySelectionNotFoundException extends ResourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public MonthlySelectionNotFoundException(Long id) {
        super("MonthlySelection not found with id: " + id);
    }
}
