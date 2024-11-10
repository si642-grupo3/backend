package com.finance.app.initialCosts.domain.model.commands;

public record CreateInitialCostCommand(
        String motivo,
        Float valor_efectivo,
        Float valor_porcentaje
) {
    public CreateInitialCostCommand {
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("motivo cannot be null or empty");
        }
        if (valor_efectivo == null) {
            throw new IllegalArgumentException("valor_efectivo cannot be null or empty");
        }
        if (valor_porcentaje == null) {
            throw new IllegalArgumentException("valor_porcentaje cannot be null or empty");
        }
    }
}
