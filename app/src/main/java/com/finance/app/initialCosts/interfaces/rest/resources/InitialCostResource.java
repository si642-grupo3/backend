package com.finance.app.initialCosts.interfaces.rest.resources;

public record InitialCostResource(Long id, String motivo, Float valor_efectivo, Float valor_porcentaje, Long factura_id) {

}
