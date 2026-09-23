package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.CoffeeRequest;
import io.github.danieledapper.pingado.dto.CoffeeResponse;
import io.github.danieledapper.pingado.entity.Coffee;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.entity.Region;

/**
 * Conversor entre a entidade Coffee e seus DTOs.
 */
public final class CoffeeMapper {

    private CoffeeMapper() {
    }

    /**
     * Converte uma entidade em sua representação de resposta.
     *
     * @param coffee entidade de café
     * @return DTO de resposta
     */
    public static CoffeeResponse toResponse(Coffee coffee) {
        Long monthlySelectionId = coffee.getMonthlySelection() != null
                ? coffee.getMonthlySelection().getId()
                : null;
        return new CoffeeResponse(
                coffee.getId(), coffee.getName(), coffee.getDescription(),
                coffee.getSensoryNotes(), coffee.getImage(),
                coffee.getRegion().getName(), monthlySelectionId
        );
    }

    /**
     * Converte um request e seus relacionamentos resolvidos em entidade.
     *
     * @param request dados recebidos pela API
     * @param region região já carregada pelo service
     * @param monthlySelection seleção mensal já carregada pelo service
     * @return entidade pronta para persistência
     */
    public static Coffee toEntity(CoffeeRequest request, Region region, MonthlySelection monthlySelection) {
        return new Coffee(null, request.name(), request.description(), request.sensoryNotes(),
                request.image(), region, monthlySelection);
    }
}
