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

/**
 * Regras de negócio e operações de persistência relacionadas aos cafés.
 */
@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final RegionRepository regionRepository;
    private final MonthlySelectionRepository monthlySelectionRepository;

    /**
     * Cria o service com as dependências necessárias.
     *
     * @param coffeeRepository repository de cafés
     * @param regionRepository repository de regiões
     * @param monthlySelectionRepository repository de seleções mensais
     */
    public CoffeeService(CoffeeRepository coffeeRepository, RegionRepository regionRepository,
                         MonthlySelectionRepository monthlySelectionRepository) {
        this.coffeeRepository = coffeeRepository;
        this.regionRepository = regionRepository;
        this.monthlySelectionRepository = monthlySelectionRepository;
    }

    /** @return todos os cafés cadastrados */
    public List<Coffee> findAll() { return coffeeRepository.findAll(); }

    /**
     * Busca um café pelo ID.
     *
     * @param id identificador do café
     * @return café encontrado
     * @throws CoffeeNotFoundException quando o ID não existir
     */
    public Coffee findById(Long id) {
        return coffeeRepository.findById(id).orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    /**
     * Cria um café resolvendo seus relacionamentos pelos IDs recebidos.
     *
     * @param request dados do café
     * @return café persistido
     * @throws RegionNotFoundException quando a região não existir
     * @throws MonthlySelectionNotFoundException quando a seleção mensal informada não existir
     */
    public Coffee create(CoffeeRequest request) {
        Region region = regionRepository.findById(request.regionId())
                .orElseThrow(() -> new RegionNotFoundException(request.regionId()));
        MonthlySelection monthlySelection = null;
        if (request.monthlySelectionId() != null) {
            monthlySelection = monthlySelectionRepository.findById(request.monthlySelectionId())
                    .orElseThrow(() -> new MonthlySelectionNotFoundException(request.monthlySelectionId()));
        }
        return coffeeRepository.save(CoffeeMapper.toEntity(request, region, monthlySelection));
    }

    /**
     * Atualiza um café existente.
     *
     * @param id identificador do café
     * @param request novos dados
     * @return café atualizado
     * @throws CoffeeNotFoundException quando o café não existir
     * @throws RegionNotFoundException quando a região não existir
     * @throws MonthlySelectionNotFoundException quando a seleção mensal informada não existir
     */
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

    /**
     * Exclui um café existente.
     *
     * @param id identificador do café
     * @throws CoffeeNotFoundException quando o café não existir
     */
    public void delete(Long id) {
        findById(id);
        coffeeRepository.deleteById(id);
    }
}
