package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.MonthSelectionRequest;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.exception.MonthlySelectionNotFoundException;
import io.github.danieledapper.pingado.repository.MonthlySelectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlySelectionService
{
    private final MonthlySelectionRepository monthlySelectionRepository;

    public MonthlySelectionService(MonthlySelectionRepository monthlySelectionRepository)
    {
        this.monthlySelectionRepository = monthlySelectionRepository;
    }

    public MonthlySelection create(MonthlySelection monthlySelection)
    {
        return monthlySelectionRepository.save(monthlySelection);
    }

    public List<MonthlySelection> findAll()
    {
        return monthlySelectionRepository.findAll();
    }

    public MonthlySelection findById(Long id)
    {
        return monthlySelectionRepository.findById(id).orElseThrow(() -> new MonthlySelectionNotFoundException(id));
    }

    public MonthlySelection update(
            Long id,
            MonthSelectionRequest request
    ) {
        MonthlySelection selection = monthlySelectionRepository
                .findById(id)
                .orElseThrow(
                        () -> new MonthlySelectionNotFoundException(id)
                );

        selection.setMonth(request.month());
        selection.setYear(request.year());
        selection.setTitle(request.title());
        selection.setDescription(request.description());

        return monthlySelectionRepository.save(selection);
    }

    public void delete(Long id)
    {
        findById(id);
        monthlySelectionRepository.deleteById(id);
    }
}
