package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.MonthSelectionRequest;
import io.github.danieledapper.pingado.dto.MonthSelectionResponse;
import io.github.danieledapper.pingado.entity.MonthlySelection;

public class MonthSelectionMapper {

    private MonthSelectionMapper() {
    }

    public static MonthlySelection toEntity(
            MonthSelectionRequest request
    ) {
        return new MonthlySelection(
                null,
                request.month(),
                request.year(),
                request.title(),
                request.description()
        );
    }

    public static MonthSelectionResponse toResponse(
            MonthlySelection selection
    ) {
        return new MonthSelectionResponse(
                selection.getId(),
                selection.getMonth(),
                selection.getYear(),
                selection.getTitle(),
                selection.getDescription()
        );
    }
}