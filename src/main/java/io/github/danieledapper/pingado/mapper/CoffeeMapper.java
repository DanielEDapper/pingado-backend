package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.CoffeeRequest;
import io.github.danieledapper.pingado.dto.CoffeeResponse;
import io.github.danieledapper.pingado.entity.Coffee;

public class CoffeeMapper
{
    public static Coffee toEntity(CoffeeRequest request)
    {
        return new Coffee(
                null,
                request.name(),
                request.description(),
                request.sensoryNotes(),
                request.image(),
                request.regionId(),
                request.monthlySelectionId()
        );
    }

    public static CoffeeResponse toResponse(Coffee coffee)
    {
        return new CoffeeResponse(
                coffee.getId(),
                coffee.getName(),
                coffee.getDescription(),
                coffee.getSensoryNotes(),
                coffee.getImage(),
                coffee.getRegionId(),
                coffee.getMonthlySelectionId()
        );
    }
}
