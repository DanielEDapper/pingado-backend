package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.RegionRequest;
import io.github.danieledapper.pingado.dto.RegionResponse;
import io.github.danieledapper.pingado.entity.Region;

/**
 * Conversor entre a entidade Region e seus DTOs.
 */
public final class RegionMapper {

    private RegionMapper() {
    }

    /**
     * Converte um request em entidade.
     *
     * @param request dados recebidos pela API
     * @return entidade Region
     */
    public static Region toEntity(RegionRequest request) {
        return new Region(null, request.name(), request.state(), request.description(),
                request.averageAltitude(), request.sensoryProfile());
    }

    /**
     * Converte uma entidade em resposta.
     *
     * @param region entidade de região
     * @return DTO de resposta
     */
    public static RegionResponse toResponse(Region region) {
        return new RegionResponse(region.getId(), region.getName(), region.getState(), region.getDescription(),
                region.getAverageAltitude(), region.getSensoryProfile());
    }
}
