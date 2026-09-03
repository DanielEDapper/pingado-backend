package io.github.danieledapper.pingado.service;

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

    public MonthlySelection update(Long id, MonthlySelection monthlySelection)
    {
        findById(id);
        monthlySelectionRepository.update(id, monthlySelection);
        monthlySelection.setId(id);
        return  monthlySelection;
    }

    public void delete(Long id)
    {
        findById(id);
        monthlySelectionRepository.deleteById(id);
    }
}
