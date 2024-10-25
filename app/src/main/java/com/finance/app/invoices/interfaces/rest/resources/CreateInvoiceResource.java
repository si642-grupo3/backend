package com.finance.app.invoices.interfaces.rest.resources;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record CreateInvoiceResource(
        String numero,
        Date fecha_emision,
        Date fecha_pago,
        Float retencion,
        Float total_facturado,
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
        if(Moneda== null) {
            throw new IllegalArgumentException("Moneda_id cannot be null");
        }
    }
}
