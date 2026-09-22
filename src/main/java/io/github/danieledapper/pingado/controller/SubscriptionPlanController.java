package io.github.danieledapper.pingado.controller;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.dto.SubscriptionPlanResponse;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import io.github.danieledapper.pingado.mapper.SubscriptionPlanMapper;
import io.github.danieledapper.pingado.service.SubscriptionPlanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-plans")
public class SubscriptionPlanController {

    private final SubscriptionPlanService service;

    public SubscriptionPlanController(
            SubscriptionPlanService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<SubscriptionPlanResponse> findAll() {
        return service.findAll()
                .stream()
                .map(SubscriptionPlanMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public SubscriptionPlanResponse findById(
            @PathVariable Long id
    ) {
        return SubscriptionPlanMapper.toResponse(
                service.findById(id)
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubscriptionPlanResponse create(
            @RequestBody SubscriptionPlanRequest request
    ) {
        SubscriptionPlan plan = service.create(request);
        return SubscriptionPlanMapper.toResponse(plan);
    }

    @PutMapping("/{id}")
    public SubscriptionPlanResponse update(
            @PathVariable Long id,
            @RequestBody SubscriptionPlanRequest request
    ) {
        return SubscriptionPlanMapper.toResponse(
                service.update(id, request)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}