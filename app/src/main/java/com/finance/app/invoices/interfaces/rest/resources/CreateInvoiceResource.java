package com.finance.app.invoices.interfaces.rest.resources;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record CreateInvoiceResource(
        String numero,
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
        Moneda Moneda
) {
    public CreateInvoiceResource{
        if(numero == null) {
            throw new IllegalArgumentException("numero cannot be null");
        }
        if(fecha_emision == null) {
            throw new IllegalArgumentException("fecha_emision cannot be null");
        }
        if(fecha_pago == null) {
            throw new IllegalArgumentException("fecha_pago cannot be null");
        }
        if(retencion == null) {
            throw new IllegalArgumentException("retencion cannot be null");
        }
        if(total_facturado == null) {
            throw new IllegalArgumentException("total_facturado cannot be null");
        }
        if(dias_anio == null) {
            throw new IllegalArgumentException("dias_anio cannot be null");
        }
        if(plazo_tasa == null) {
            throw new IllegalArgumentException("plazo_tasa cannot be null");
        }
        if(tasa_nominal == null) {
            throw new IllegalArgumentException("tasa_nominal cannot be null");
        }
        if(tasa_efectiva == null) {
            throw new IllegalArgumentException("tasa_efectiva cannot be null");
        }
        if(periodo_capitalizacion == null) {
            throw new IllegalArgumentException("periodo_capitalizacion cannot be null");
        }
        if(fecha_descuento == null) {
            throw new IllegalArgumentException("fecha_descuento cannot be null");
        }
        if(Moneda== null) {
            throw new IllegalArgumentException("Moneda_id cannot be null");
        }
    }
}
