package io.github.danieledapper.pingado.mapper;

import io.github.danieledapper.pingado.dto.PaymentRequest;
import io.github.danieledapper.pingado.dto.PaymentResponse;
import io.github.danieledapper.pingado.entity.Payment;

public class PaymentMapper {

    private PaymentMapper() {
    }

    public static Payment toEntity(PaymentRequest request) {
        Payment payment = new Payment();

        payment.setPaymentDate(request.paymentDate());
        payment.setAmount(request.amount());
        payment.setPaymentMethod(request.paymentMethod());
        payment.setStatus(request.status());

        return payment;
    }

    public static PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getPaymentDate(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getStatus(),
                payment.getUserSubscription().getId()
        );
    }
}