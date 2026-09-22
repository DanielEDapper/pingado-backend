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

/**
 * Regras de negócio e operações de persistência dos pagamentos.
 */
@Service
public class PaymentService {

    private final PaymentRepository repository;
    private final UserSubscriptionRepository subscriptionRepository;

    /**
     * Cria o service com seus repositories.
     *
     * @param repository repository de pagamentos
     * @param subscriptionRepository repository de assinaturas
     */
    public PaymentService(PaymentRepository repository, UserSubscriptionRepository subscriptionRepository) {
        this.repository = repository;
        this.subscriptionRepository = subscriptionRepository;
    }

    /** @return todos os pagamentos */
    public List<Payment> findAll() { return repository.findAll(); }

    /**
     * Busca um pagamento pelo ID.
     *
     * @param id identificador do pagamento
     * @return pagamento encontrado
     * @throws PaymentNotFoundException quando o ID não existir
     */
    public Payment findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

    /**
     * Cria um pagamento resolvendo a assinatura pelo ID recebido.
     *
     * @param request dados do pagamento
     * @return pagamento persistido
     * @throws UserSubscriptionNotFoundException quando a assinatura não existir
     */
    public Payment create(PaymentRequest request) {
        UserSubscription subscription = subscriptionRepository.findById(request.userSubscriptionId())
                .orElseThrow(() -> new UserSubscriptionNotFoundException(request.userSubscriptionId()));
        Payment payment = PaymentMapper.toEntity(request);
        payment.setUserSubscription(subscription);
        return repository.save(payment);
    }

    /**
     * Atualiza um pagamento existente.
     *
     * @param id identificador do pagamento
     * @param request novos dados
     * @return pagamento atualizado
     * @throws PaymentNotFoundException quando o pagamento não existir
     * @throws UserSubscriptionNotFoundException quando a assinatura não existir
     */
    public Payment update(Long id, PaymentRequest request) {
        Payment payment = findById(id);
        UserSubscription subscription = subscriptionRepository.findById(request.userSubscriptionId())
                .orElseThrow(() -> new UserSubscriptionNotFoundException(request.userSubscriptionId()));
        payment.setPaymentDate(request.paymentDate());
        payment.setAmount(request.amount());
        payment.setPaymentMethod(request.paymentMethod());
        payment.setStatus(request.status());
        payment.setUserSubscription(subscription);
        return repository.save(payment);
    }

    /**
     * Exclui um pagamento existente.
     *
     * @param id identificador do pagamento
     * @throws PaymentNotFoundException quando o ID não existir
     */
    public void delete(Long id) {
        Payment payment = findById(id);
        repository.delete(payment);
    }
}
