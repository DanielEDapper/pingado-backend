package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.RegionRequest;
import io.github.danieledapper.pingado.entity.Region;
import io.github.danieledapper.pingado.exception.RegionNotFoundException;
import io.github.danieledapper.pingado.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras de negócio e operações de persistência das regiões produtoras.
 */
@Service
public class RegionService {

    private final RegionRepository regionRepository;

    /**
     * Cria o service com seu repository.
     *
     * @param regionRepository repository de regiões
     */
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /** @return todas as regiões cadastradas */
    public List<Region> findAll() { return regionRepository.findAll(); }

    /**
     * Busca uma região pelo ID.
     *
     * @param id identificador da região
     * @return região encontrada
     * @throws RegionNotFoundException quando o ID não existir
     */
    public Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
    }

    /**
     * Persiste uma região.
     *
     * @param region entidade a ser salva
     * @return região persistida
     */
    public Region create(Region region) { return regionRepository.save(region); }

    /**
     * Atualiza uma região existente.
     *
     * @param id identificador da região
     * @param request novos dados
     * @return região atualizada
     * @throws RegionNotFoundException quando o ID não existir
     */
    public Region update(Long id, RegionRequest request) {
        Region region = findById(id);
        region.setName(request.name());
        region.setState(request.state());
        region.setDescription(request.description());
        region.setAverageAltitude(request.averageAltitude());
        region.setSensoryProfile(request.sensoryProfile());
        return regionRepository.save(region);
    }

    /**
     * Exclui uma região existente.
     *
     * @param id identificador da região
     * @throws RegionNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        findById(id);
        regionRepository.deleteById(id);
    }
}
