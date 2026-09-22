package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Dados recebidos para criação ou atualização de um pagamento.
 */
@Schema(description = "Dados necessários para criar ou atualizar um pagamento.")
public record PaymentRequest(
        @Schema(description = "Data do pagamento.", example = "2026-09-22") LocalDate paymentDate,
        @Schema(description = "Valor do pagamento.", example = "42.90") BigDecimal amount,
        @Schema(description = "Método de pagamento.", example = "PIX") String paymentMethod,
        @Schema(description = "Status do pagamento.", example = "PAGO") String status,
        @Schema(description = "ID da assinatura relacionada.", example = "1") Long userSubscriptionId
) {
}
