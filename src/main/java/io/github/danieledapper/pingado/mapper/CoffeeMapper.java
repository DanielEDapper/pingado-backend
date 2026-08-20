package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.CoffeeRequest;
import io.github.danieledapper.pingado.dto.CoffeeResponse;
import io.github.danieledapper.pingado.entity.Coffee;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.entity.Region;

public class CoffeeMapper
{
    public static CoffeeResponse toResponse(Coffee coffee) {
        Long monthlySelectionId = coffee.getMonthlySelection() != null
                ? coffee.getMonthlySelection().getId()
                : null;

        return new CoffeeResponse(
                coffee.getId(),
                coffee.getName(),
                coffee.getDescription(),
                coffee.getSensoryNotes(),
                coffee.getImage(),
                coffee.getRegion().getId(),
                monthlySelectionId
        );
    }

    public static Coffee toEntity(CoffeeRequest request, Region region, MonthlySelection monthlySelection) {
        return new Coffee(null,
                request.name(),
                request.description(),
                request.sensoryNotes(),
                request.image(),
                region,
                monthlySelection);
    }
}
