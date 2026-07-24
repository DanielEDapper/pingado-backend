package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.MonthSelectionRequest;
import io.github.danieledapper.pingado.dto.MonthSelectionResponse;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.mapper.MonthSelectionMapper;
import io.github.danieledapper.pingado.service.MonthlySelectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-selection")
public class MonthlySelectionController
{
    private final MonthlySelectionService monthlySelectionService;

    public MonthlySelectionController(MonthlySelectionService monthlySelectionService)
    {
        this.monthlySelectionService = monthlySelectionService;
    }

    @GetMapping
    public List<MonthSelectionResponse> findAll()
    {
        return monthlySelectionService.findAll().stream().map(MonthSelectionMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public MonthSelectionResponse findById(@PathVariable Long id)
    {
        MonthlySelection monthlySelection = monthlySelectionService.findById(id);
        return MonthSelectionMapper.toResponse(monthlySelection);
    }

    @PostMapping
    public MonthSelectionResponse create(@RequestBody MonthSelectionRequest request)
    {
        MonthlySelection monthlySelection = MonthSelectionMapper.toEntity(request);
        MonthlySelection savedMonthlySelection = monthlySelectionService.create(monthlySelection);
        return MonthSelectionMapper.toResponse(savedMonthlySelection);
    }

    @PutMapping("/{id}")
    public MonthSelectionResponse update(@PathVariable Long id, @RequestBody MonthSelectionRequest request)
    {
        MonthlySelection monthlySelection = MonthSelectionMapper.toEntity(request);
        MonthlySelection savedMonthlySelection = monthlySelectionService.update(id, monthlySelection);
        return MonthSelectionMapper.toResponse(savedMonthlySelection);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        monthlySelectionService.delete(id);
    }
}
