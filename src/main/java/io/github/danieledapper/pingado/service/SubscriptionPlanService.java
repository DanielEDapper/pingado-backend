package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.SubscriptionPlanRequest;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import io.github.danieledapper.pingado.exception.SubscriptionPlanNotFoundException;
import io.github.danieledapper.pingado.mapper.SubscriptionPlanMapper;
import io.github.danieledapper.pingado.repository.SubscriptionPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras de negócio e operações de persistência dos planos de assinatura.
 */
@Service
public class SubscriptionPlanService {

    private final SubscriptionPlanRepository repository;

    /**
     * Cria o service com seu repository.
     *
     * @param repository repository de planos
     */
    public SubscriptionPlanService(SubscriptionPlanRepository repository) {
        this.repository = repository;
    }

    /** @return todos os planos cadastrados */
    public List<SubscriptionPlan> findAll() { return repository.findAll(); }

    /**
     * Busca um plano pelo ID.
     *
     * @param id identificador do plano
     * @return plano encontrado
     * @throws SubscriptionPlanNotFoundException quando o ID não existir
     */
    public SubscriptionPlan findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new SubscriptionPlanNotFoundException(id));
    }

    /**
     * Cria um plano.
     *
     * @param request dados do plano
     * @return plano persistido
     */
    public SubscriptionPlan create(SubscriptionPlanRequest request) {
        return repository.save(SubscriptionPlanMapper.toEntity(request));
    }

    /**
     * Atualiza um plano existente.
     *
     * @param id identificador do plano
     * @param request novos dados
     * @return plano atualizado
     * @throws SubscriptionPlanNotFoundException quando o ID não existir
     */
    public SubscriptionPlan update(Long id, SubscriptionPlanRequest request) {
        SubscriptionPlan plan = findById(id);
        plan.setName(request.name());
        plan.setDescription(request.description());
        plan.setPrice(request.price());
        plan.setPeriodicity(request.periodicity());
        return repository.save(plan);
    }

    /**
     * Exclui um plano existente.
     *
     * @param id identificador do plano
     * @throws SubscriptionPlanNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        SubscriptionPlan plan = findById(id);
        repository.delete(plan);
    }
}
