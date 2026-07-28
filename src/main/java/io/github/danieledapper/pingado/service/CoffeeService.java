package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.entity.Coffee;
import io.github.danieledapper.pingado.exception.CoffeeNotFoundException;
import io.github.danieledapper.pingado.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService
{
    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository)
    {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> findAll()
    {
        return coffeeRepository.findAll();
    }

    public Coffee findById(Long id)
    {
        return coffeeRepository.findById(id).orElseThrow(() -> new CoffeeNotFoundException(id));
    }

    public Coffee create(Coffee coffee)
    {
        return coffeeRepository.save(coffee);
    }

    public Coffee update(Long id, Coffee coffee)
    {
        findById(id);
        coffeeRepository.update(id, coffee);
        coffee.setId(id);
        return coffee;
    }

    public void delete(Long id)
    {
        findById(id);
        coffeeRepository.deleteById(id);
    }
}
