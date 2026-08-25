package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.CoffeeRequest;
import io.github.danieledapper.pingado.entity.Coffee;
import io.github.danieledapper.pingado.entity.MonthlySelection;
import io.github.danieledapper.pingado.entity.Region;
import io.github.danieledapper.pingado.exception.CoffeeNotFoundException;
import io.github.danieledapper.pingado.exception.MonthlySelectionNotFoundException;
import io.github.danieledapper.pingado.exception.RegionNotFoundException;
import io.github.danieledapper.pingado.mapper.CoffeeMapper;
import io.github.danieledapper.pingado.repository.CoffeeRepository;
import io.github.danieledapper.pingado.repository.MonthlySelectionRepository;
import io.github.danieledapper.pingado.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final RegionRepository regionRepository;
    private final MonthlySelectionRepository monthlySelectionRepository;

    public CoffeeService(CoffeeRepository coffeeRepository,
                         RegionRepository regionRepository,
                         MonthlySelectionRepository monthlySelectionRepository) {
        this.coffeeRepository = coffeeRepository;
        this.regionRepository = regionRepository;
        this.monthlySelectionRepository = monthlySelectionRepository;
    }

    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    public Coffee findById(Long id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    public Coffee create(CoffeeRequest request) {
        Region region = regionRepository.findById(request.regionId())
                .orElseThrow(() -> new RegionNotFoundException(request.regionId()));

        MonthlySelection monthlySelection = null;
        if (request.monthlySelectionId() != null) {
            monthlySelection = monthlySelectionRepository.findById(request.monthlySelectionId())
                    .orElseThrow(() -> new MonthlySelectionNotFoundException(request.monthlySelectionId()));
        }

        Coffee coffee = CoffeeMapper.toEntity(request, region, monthlySelection);
        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, CoffeeRequest request) {
        Coffee existing = findById(id);

        Region region = regionRepository.findById(request.regionId())
                .orElseThrow(() -> new RegionNotFoundException(request.regionId()));

        MonthlySelection monthlySelection = null;
        if (request.monthlySelectionId() != null) {
            monthlySelection = monthlySelectionRepository.findById(request.monthlySelectionId())
                    .orElseThrow(() -> new MonthlySelectionNotFoundException(request.monthlySelectionId()));
        }

        existing.setName(request.name());
        existing.setDescription(request.description());
        existing.setSensoryNotes(request.sensoryNotes());
        existing.setImage(request.image());
        existing.setRegion(region);
        existing.setMonthlySelection(monthlySelection);

        return coffeeRepository.save(existing);
    }

    public void delete(Long id) {
        findById(id);
        coffeeRepository.deleteById(id);
    }
}