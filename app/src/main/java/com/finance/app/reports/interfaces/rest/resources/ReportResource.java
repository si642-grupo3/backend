package com.finance.app.reports.interfaces.rest.resources;

import java.util.Date;

public record ReportResource(
        Long id,
        Date fecha_giro,
        Date fecha_vencimiento,
        Integer dias_transcurridos,
        Float valor_nominal,
        Float retencion,
        Float tasa_efectiva,
        Float tasa_descuento,
        Float descuento,
        Float coste_inicial,
        Float coste_final,
        Float valor_neto,
        Float valor_recibido,
        Float valor_entregado,
        Float tcea,
        Long factura_id,
        Long cartera_id
) {
}
