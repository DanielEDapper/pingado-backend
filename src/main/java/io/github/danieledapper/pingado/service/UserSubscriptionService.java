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

@Service
public class UserSubscriptionService {

    private final UserSubscriptionRepository repository;
    private final UserRepository userRepository;
    private final SubscriptionPlanRepository planRepository;

    public UserSubscriptionService(
            UserSubscriptionRepository repository,
            UserRepository userRepository,
            SubscriptionPlanRepository planRepository
    ) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    public List<UserSubscription> findAll() {
        return repository.findAll();
    }

    public UserSubscription findById(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new UserSubscriptionNotFoundException(id)
                );
    }

    public UserSubscription create(
            UserSubscriptionRequest request
    ) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(
                        () -> new UserNotFoundException(request.userId())
                );

        SubscriptionPlan plan =
                planRepository.findById(request.subscriptionPlanId())
                        .orElseThrow(
                                () -> new SubscriptionPlanNotFoundException(
                                        request.subscriptionPlanId()
                                )
                        );

        UserSubscription subscription =
                UserSubscriptionMapper.toEntity(request);

        subscription.setUser(user);
        subscription.setSubscriptionPlan(plan);

        return repository.save(subscription);
    }

    public UserSubscription update(
            Long id,
            UserSubscriptionRequest request
    ) {
        UserSubscription subscription = findById(id);

        User user = userRepository.findById(request.userId())
                .orElseThrow(
                        () -> new UserNotFoundException(request.userId())
                );

        SubscriptionPlan plan =
                planRepository.findById(request.subscriptionPlanId())
                        .orElseThrow(
                                () -> new SubscriptionPlanNotFoundException(
                                        request.subscriptionPlanId()
                                )
                        );

        subscription.setStartDate(request.startDate());
        subscription.setEndDate(request.endDate());
        subscription.setStatus(request.status());
        subscription.setUser(user);
        subscription.setSubscriptionPlan(plan);

        return repository.save(subscription);
    }

    public void delete(Long id) {
        UserSubscription subscription = findById(id);
        repository.delete(subscription);
    }
}