package com.finance.app.invoices.interfaces.rest.resources;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record UpdateInvoiceResource(
        Long id,
        Date fecha_emision,
        Date fecha_pago,
        Float retencion,
        Float total_facturado,
        Moneda Moneda
) {
}
