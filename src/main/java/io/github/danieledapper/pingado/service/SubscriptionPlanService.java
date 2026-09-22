package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import io.github.danieledapper.pingado.exception.SubscriptionPlanNotFoundException;
import io.github.danieledapper.pingado.mapper.SubscriptionPlanMapper;
import io.github.danieledapper.pingado.repository.SubscriptionPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionPlanService {

    private final SubscriptionPlanRepository repository;

    public SubscriptionPlanService(
            SubscriptionPlanRepository repository
    ) {
        this.repository = repository;
    }

    public List<SubscriptionPlan> findAll() {
        return repository.findAll();
    }

    public SubscriptionPlan findById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new SubscriptionPlanNotFoundException(id)
                );
    }

    public SubscriptionPlan create(
            SubscriptionPlanRequest request
    ) {
        SubscriptionPlan plan =
                SubscriptionPlanMapper.toEntity(request);

        return repository.save(plan);
    }

    public SubscriptionPlan update(
            Long id,
            SubscriptionPlanRequest request
    ) {
        SubscriptionPlan plan = findById(id);

        plan.setName(request.name());
        plan.setDescription(request.description());
        plan.setPrice(request.price());
        plan.setPeriodicity(request.periodicity());

        return repository.save(plan);
    }

    public void delete(Long id) {
        SubscriptionPlan plan = findById(id);
        repository.delete(plan);
    }
}