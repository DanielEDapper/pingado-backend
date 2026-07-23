package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.RegionRequest;
import io.github.danieledapper.pingado.dto.RegionResponse;
import io.github.danieledapper.pingado.entity.Region;

public class RegionMapper
{
    public static Region toEntity(RegionRequest request)
    {
        return new Region(null,
                request.name(),
                request.state(),
                request.description(),
                request.averageAltitude(),
                request.sensoryProfile());
    }

    public static RegionResponse toResponse(Region region)
    {
        return new RegionResponse(region.getId(),
                region.getName(),
                region.getState(),
                region.getDescription(),
                region.getAverageAltitude(),
                region.getSensoryProfile());
    }
}
