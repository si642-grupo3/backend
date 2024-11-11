package com.finance.app.finalCosts.interfaces.rest.resources;

public record FinalCostResource(Long id, String motivo, Float valor_efectivo, Float valor_porcentaje, Long factura_id) {

}
