package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.MonthSelectionRequest;
import io.github.danieledapper.pingado.dto.MonthSelectionResponse;
import io.github.danieledapper.pingado.entity.MonthlySelection;

public class MonthSelectionMapper
{
    public static MonthlySelection toEntity(MonthSelectionRequest request)
    {
        return new MonthlySelection(null,
                request.month(),
                request.year(),
                request.title(),
                request.description()
        );
    }

    public static MonthSelectionResponse toResponse(MonthlySelection monthlySelection)
    {
        return new MonthSelectionResponse(
                monthlySelection.getId(),
                monthlySelection.getMonth(),
                monthlySelection.getYear(),
                monthlySelection.getTitle(),
                monthlySelection.getDescription());
    }
}
