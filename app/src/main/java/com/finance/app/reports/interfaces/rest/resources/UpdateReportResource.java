package com.finance.app.reports.interfaces.rest.resources;

import java.util.Date;

public record UpdateReportResource(
        Long id,
        Date fechaGiro,
        Date fechaVencimiento,
        Integer diasTranscurridos,
        Float valorNominal,
        Float retencion,
        Float tasaEfectiva,
        Float tasaDescuento,
        Float descuento,
        Float costeInicial,
        Float costeFinal,
        Float valorNeto,
        Float valorRecibido,
        Float valorEntregado,
        Float tcea,
        Long factura_id,
        Long cartera_id
) {
}
