package com.finance.app.invoices.interfaces.rest.transform;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.interfaces.rest.resources.InvoiceResource;

public class InvoiceResourceFromEntityAssembler {

    public static InvoiceResource toResourceFromEntity(Factura entity){
        return new InvoiceResource(
                entity.getId(),
                entity.getNumero(),
                entity.getFecha_emision(),
                entity.getFecha_pago(),
                entity.getRetencion(),
                entity.getTotal_facturado(),
                entity.getIgv(),
                entity.getDias_anio(),
                entity.getPlazo_tasa(),
                entity.getTasa_nominal(),
                entity.getTasa_efectiva(),
                entity.getPeriodo_capitalizacion(),
                entity.getFecha_descuento(),
                entity.getMoneda()
        );
    }
}
