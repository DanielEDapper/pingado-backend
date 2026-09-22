package io.github.danieledapper.pingado.exception;

/**
 * Exceção lançada quando o recurso region não é encontrado.
 */
public class RegionNotFoundException extends RecourceNotFoundException {

    /**
     * Cria a exceção para o identificador informado.
     *
     * @param id identificador do recurso não encontrado
     */
    public RegionNotFoundException(Long id) {
        super("Region not found with id: " + id);
    }
}
