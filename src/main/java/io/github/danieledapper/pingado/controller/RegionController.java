package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.RegionRequest;
import io.github.danieledapper.pingado.dto.RegionResponse;
import io.github.danieledapper.pingado.entity.Region;
import io.github.danieledapper.pingado.mapper.RegionMapper;
import io.github.danieledapper.pingado.service.RegionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
    public class RegionController
{
    private final RegionService regionService;

    public RegionController(RegionService regionService)
    {
        this.regionService = regionService;
    }

    @GetMapping
    public List<RegionResponse> findAll()
    {
        return regionService.findAll().stream().map(RegionMapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    public RegionResponse findById(@PathVariable Long id)
    {
        Region region = regionService.findById(id);
        return RegionMapper.toResponse(region);
    }

    @PostMapping
    public RegionResponse create(@RequestBody RegionRequest request)
    {
        Region region = RegionMapper.toEntity(request);
        Region savedRegion = regionService.create(region);
        return RegionMapper.toResponse(savedRegion);
    }

    @PutMapping("/{id}")
    public RegionResponse update(@PathVariable Long id, @RequestBody RegionRequest request)
    {
        Region region = RegionMapper.toEntity(request);
        Region updatedRegion = regionService.update(id, region);
        return RegionMapper.toResponse(updatedRegion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        regionService.delete(id);
    }
}
