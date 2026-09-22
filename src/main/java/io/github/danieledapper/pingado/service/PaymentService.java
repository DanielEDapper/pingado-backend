package io.github.danieledapper.pingado.service;

import io.github.danieledapper.pingado.dto.PaymentRequest;
import io.github.danieledapper.pingado.entity.Payment;
import io.github.danieledapper.pingado.entity.UserSubscription;
import io.github.danieledapper.pingado.exception.PaymentNotFoundException;
import io.github.danieledapper.pingado.exception.UserSubscriptionNotFoundException;
import io.github.danieledapper.pingado.mapper.PaymentMapper;
import io.github.danieledapper.pingado.repository.PaymentRepository;
import io.github.danieledapper.pingado.repository.UserSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final UserSubscriptionRepository subscriptionRepository;

    public PaymentService(
            PaymentRepository repository,
            UserSubscriptionRepository subscriptionRepository
    ) {
        this.repository = repository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException(id));
    }

    public Payment create(PaymentRequest request) {
        UserSubscription subscription =
                subscriptionRepository.findById(
                        request.userSubscriptionId()
                ).orElseThrow(
                        () -> new UserSubscriptionNotFoundException(
                                request.userSubscriptionId()
                        )
                );

        Payment payment = PaymentMapper.toEntity(request);
        payment.setUserSubscription(subscription);

        return repository.save(payment);
    }

    public Payment update(Long id, PaymentRequest request) {
        Payment payment = findById(id);

        UserSubscription subscription =
                subscriptionRepository.findById(
                        request.userSubscriptionId()
                ).orElseThrow(
                        () -> new UserSubscriptionNotFoundException(
                                request.userSubscriptionId()
                        )
                );

        payment.setPaymentDate(request.paymentDate());
        payment.setAmount(request.amount());
        payment.setPaymentMethod(request.paymentMethod());
        payment.setStatus(request.status());
        payment.setUserSubscription(subscription);

        return repository.save(payment);
    }

    public void delete(Long id) {
        Payment payment = findById(id);
        repository.delete(payment);
    }
}