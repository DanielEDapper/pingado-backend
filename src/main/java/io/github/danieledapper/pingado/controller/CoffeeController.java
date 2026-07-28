package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.CoffeeRequest;
import io.github.danieledapper.pingado.dto.CoffeeResponse;
import io.github.danieledapper.pingado.entity.Coffee;
import io.github.danieledapper.pingado.mapper.CoffeeMapper;
import io.github.danieledapper.pingado.service.CoffeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController
{
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService)
    {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<CoffeeResponse> findAll()
    {
        return coffeeService.findAll().stream().map(CoffeeMapper::toResponse).toList();
    }

    @GetMapping("{id}")
    public CoffeeResponse findById(@PathVariable Long id)
    {
        Coffee coffee = coffeeService.findById(id);
        return CoffeeMapper.toResponse(coffee);
    }

    @PostMapping
    public CoffeeResponse create(@RequestBody CoffeeRequest request)
    {
        Coffee coffee = CoffeeMapper.toEntity(request);
        Coffee coffeeSaved = coffeeService.create(coffee);
        return CoffeeMapper.toResponse(coffeeSaved);
    }

    @PutMapping("{id}")
    public CoffeeResponse update(@PathVariable Long id, @RequestBody CoffeeRequest request)
    {
        Coffee coffee = CoffeeMapper.toEntity(request);
        Coffee coffeeSaved = coffeeService.update(id, coffee);
        return CoffeeMapper.toResponse(coffeeSaved);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id)
    {
        coffeeService.delete(id);
    }
}
