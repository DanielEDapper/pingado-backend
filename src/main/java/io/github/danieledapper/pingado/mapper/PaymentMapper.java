package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.PaymentRequest;
import io.github.danieledapper.pingado.dto.PaymentResponse;
import io.github.danieledapper.pingado.entity.Payment;

/**
 * Conversor entre a entidade Payment e seus DTOs.
 */
public final class PaymentMapper {

    private PaymentMapper() {
    }

    /**
     * Converte um request em entidade, deixando o relacionamento para o service.
     *
     * @param request dados recebidos pela API
     * @return entidade Payment
     */
    public static Payment toEntity(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setPaymentDate(request.paymentDate());
        payment.setAmount(request.amount());
        payment.setPaymentMethod(request.paymentMethod());
        payment.setStatus(request.status());
        return payment;
    }

    /**
     * Converte uma entidade em resposta.
     *
     * @param payment entidade de pagamento
     * @return DTO de resposta
     */
    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(payment.getId(), payment.getPaymentDate(), payment.getAmount(),
                payment.getPaymentMethod(), payment.getStatus(), payment.getUserSubscription().getId());
    }
}
