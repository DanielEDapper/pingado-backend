package io.github.danieledapper.pingado.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Dados retornados pela API para um pagamento.
 */
@Schema(description = "Representação de um pagamento retornada pela API.")
public record PaymentResponse(
        @Schema(description = "ID do pagamento.", example = "1") Long id,
        @Schema(description = "Data do pagamento.", example = "2026-09-22") LocalDate paymentDate,
        @Schema(description = "Valor pago.", example = "42.90") BigDecimal amount,
        @Schema(description = "Método de pagamento.", example = "PIX") String paymentMethod,
        @Schema(description = "Status do pagamento.", example = "PAGO") String status,
        @Schema(description = "ID da assinatura relacionada.", example = "1") Long userSubscriptionId
) {
}
