package com.finance.app.invoices.domain.model.commands;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record CreateInvoiceCommand(
        String numero,
        Date fecha_emision,
        Date fecha_pago,
        Float retencion,
        Float total_facturado,
        Moneda Moneda
) {
    public CreateInvoiceCommand{
        if(numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("numero cannot be null or empty");
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
        if (Moneda == null) {
            throw new IllegalArgumentException("Moneda cannot be null");
        }
    }
}
