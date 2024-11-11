package com.finance.app.initialCosts.interfaces.rest.resources;

public record CreateInitialCostResource(
        String motivo,
        Float valor_efectivo,
        Float valor_porcentaje,
        Long factura_id
) {
    public CreateInitialCostResource{
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("motivo cannot be null or empty");
        }
        if (valor_efectivo == null) {
            throw new IllegalArgumentException("valor_efectivo cannot be null");
        }
        if (valor_porcentaje == null) {
            throw new IllegalArgumentException("valor_porcentaje cannot be null");
        }
        if (factura_id == null) {
            throw new IllegalArgumentException("factura_id cannot be null");
        }
    }

}
