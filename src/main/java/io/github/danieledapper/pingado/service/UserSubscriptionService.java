package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.UserSubscriptionRequest;
import io.github.danieledapper.pingado.entity.SubscriptionPlan;
import io.github.danieledapper.pingado.entity.User;
import io.github.danieledapper.pingado.entity.UserSubscription;
import io.github.danieledapper.pingado.exception.SubscriptionPlanNotFoundException;
import io.github.danieledapper.pingado.exception.UserNotFoundException;
import io.github.danieledapper.pingado.exception.UserSubscriptionNotFoundException;
import io.github.danieledapper.pingado.mapper.UserSubscriptionMapper;
import io.github.danieledapper.pingado.repository.SubscriptionPlanRepository;
import io.github.danieledapper.pingado.repository.UserRepository;
import io.github.danieledapper.pingado.repository.UserSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Regras de negócio e operações de persistência das assinaturas de usuários.
 */
@Service
public class UserSubscriptionService {

    private final UserSubscriptionRepository repository;
    private final UserRepository userRepository;
    private final SubscriptionPlanRepository planRepository;

    /**
     * Cria o service com seus repositories.
     *
     * @param repository repository de assinaturas
     * @param userRepository repository de usuários
     * @param planRepository repository de planos
     */
    public UserSubscriptionService(UserSubscriptionRepository repository, UserRepository userRepository,
                                   SubscriptionPlanRepository planRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    /** @return todas as assinaturas */
    public List<UserSubscription> findAll() { return repository.findAll(); }

    /**
     * Busca uma assinatura pelo ID.
     *
     * @param id identificador da assinatura
     * @return assinatura encontrada
     * @throws UserSubscriptionNotFoundException quando o ID não existir
     */
    public UserSubscription findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserSubscriptionNotFoundException(id));
    }

    /**
     * Cria uma assinatura resolvendo usuário e plano pelos IDs do request.
     *
     * @param request dados da assinatura
     * @return assinatura persistida
     * @throws UserNotFoundException quando o usuário não existir
     * @throws SubscriptionPlanNotFoundException quando o plano não existir
     */
    public UserSubscription create(UserSubscriptionRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId()));
        SubscriptionPlan plan = planRepository.findById(request.subscriptionPlanId())
                .orElseThrow(() -> new SubscriptionPlanNotFoundException(request.subscriptionPlanId()));
        UserSubscription subscription = UserSubscriptionMapper.toEntity(request);
        subscription.setUser(user);
        subscription.setSubscriptionPlan(plan);
        return repository.save(subscription);
    }

    /**
     * Atualiza uma assinatura resolvendo novamente seus relacionamentos pelos IDs.
     *
     * @param id identificador da assinatura
     * @param request novos dados
     * @return assinatura atualizada
     * @throws UserSubscriptionNotFoundException quando a assinatura não existir
     * @throws UserNotFoundException quando o usuário não existir
     * @throws SubscriptionPlanNotFoundException quando o plano não existir
     */
    public UserSubscription update(Long id, UserSubscriptionRequest request) {
        UserSubscription subscription = findById(id);
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new UserNotFoundException(request.userId()));
        SubscriptionPlan plan = planRepository.findById(request.subscriptionPlanId())
                .orElseThrow(() -> new SubscriptionPlanNotFoundException(request.subscriptionPlanId()));
        subscription.setStartDate(request.startDate());
        subscription.setEndDate(request.endDate());
        subscription.setStatus(request.status());
        subscription.setUser(user);
        subscription.setSubscriptionPlan(plan);
        return repository.save(subscription);
    }

    /**
     * Exclui uma assinatura existente.
     *
     * @param id identificador da assinatura
     * @throws UserSubscriptionNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        UserSubscription subscription = findById(id);
        repository.delete(subscription);
    }
}
