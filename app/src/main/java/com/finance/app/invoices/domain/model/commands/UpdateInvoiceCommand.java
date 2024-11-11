package com.finance.app.invoices.domain.model.commands;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record UpdateInvoiceCommand(
        Long id,
        Date fecha_emision,
        Date fecha_pago,
        Float retencion,
        Float total_facturado,
        Integer dias_anio,
        Integer plazo_tasa,
        Float tasa_nominal,
        Float tasa_efectiva,
        Integer periodo_capitalizacion,
        Date fecha_descuento,
        Long moneda
) {
    public UpdateInvoiceCommand {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (fecha_emision == null) {
            throw new IllegalArgumentException("fecha_emision cannot be null");
        }
        if (fecha_pago == null) {
            throw new IllegalArgumentException("fecha_pago cannot be null");
        }
        if (retencion == null) {
            throw new IllegalArgumentException("retencion cannot be null");
        }
        if (total_facturado == null) {
            throw new IllegalArgumentException("total_facturado cannot be null");
        }
        if (dias_anio == null) {
            throw new IllegalArgumentException("dias_anio cannot be null");
        }
        if (plazo_tasa == null) {
            throw new IllegalArgumentException("plazo_tasa cannot be null");
        }
        if (tasa_nominal == null) {
            throw new IllegalArgumentException("tasa_nominal cannot be null");
        }
        if (tasa_efectiva == null) {
            throw new IllegalArgumentException("tasa_efectiva cannot be null");
        }
        if (periodo_capitalizacion == null) {
            throw new IllegalArgumentException("periodo_capitalizacion cannot be null");
        }
        if (fecha_descuento == null) {
            throw new IllegalArgumentException("fecha_descuento cannot be null");
        }
        if (moneda == null) {
            throw new IllegalArgumentException("Moneda_id cannot be null");
        }
    }
}
