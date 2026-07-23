package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.entity.Region;
import io.github.danieledapper.pingado.exception.RegionNotFoundException;
import io.github.danieledapper.pingado.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService
{
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository)
    {
        this.regionRepository = regionRepository;
    }

    public List<Region> findAll()
    {
        return regionRepository.findAll();
    }

    public Region findById(Long id)
    {
         return regionRepository.findById(id).orElseThrow(() -> new RegionNotFoundException(id));
    }

    public Region create(Region region)
    {
        return regionRepository.save(region);
    }

    public Region update(Long id, Region region)
    {
        findById(id);
        regionRepository.update(id, region);
        region.setId(id);
        return region;
    }

    public void delete(Long id)
    {
        findById(id);
        regionRepository.deleteById(id);
    }

}
