package com.finance.app.invoices.interfaces.rest.resources;

import com.finance.app.invoices.domain.model.entities.Moneda;

import java.util.Date;

public record InvoiceResource(
        Long id,
        String numero,
        Date fecha_emision,
        Date fecha_pago,
        Float retencion,
        Float total_facturado,
        Float igv,
        Integer dias_anio,
        Integer plazo_tasa,
        Float tasa_nominal,
        Float tasa_efectiva,
        Integer periodo_capitalizacion,
        Date fecha_descuento,
        Moneda Moneda
) {
}
