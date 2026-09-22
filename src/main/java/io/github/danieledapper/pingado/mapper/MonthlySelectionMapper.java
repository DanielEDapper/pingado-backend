package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.MonthlySelectionRequest;
import io.github.danieledapper.pingado.dto.MonthlySelectionResponse;
import io.github.danieledapper.pingado.entity.MonthlySelection;

/**
 * Conversor entre a entidade MonthlySelection e seus DTOs.
 *
 * <p>O nome MonthSelection é mantido para acompanhar os nomes atuais dos DTOs do projeto.</p>
 */
public final class MonthlySelectionMapper {

    private MonthlySelectionMapper() {
    }

    /**
     * Converte um request em entidade.
     *
     * @param request dados recebidos pela API
     * @return entidade MonthlySelection
     */
    public static MonthlySelection toEntity(MonthlySelectionRequest request) {
        return new MonthlySelection(null, request.month(), request.year(), request.title(), request.description());
    }

    /**
     * Converte uma entidade em resposta.
     *
     * @param selection entidade de seleção mensal
     * @return DTO de resposta
     */
    public static MonthlySelectionResponse toResponse(MonthlySelection selection) {
        return new MonthlySelectionResponse(selection.getId(), selection.getMonth(), selection.getYear(),
                selection.getTitle(), selection.getDescription());
    }
}
