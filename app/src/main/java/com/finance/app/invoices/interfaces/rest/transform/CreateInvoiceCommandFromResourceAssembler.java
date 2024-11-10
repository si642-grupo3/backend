package com.finance.app.invoices.interfaces.rest.transform;

import com.finance.app.invoices.domain.model.commands.CreateInvoiceCommand;
import com.finance.app.invoices.interfaces.rest.resources.CreateInvoiceResource;

public class CreateInvoiceCommandFromResourceAssembler {

    public static CreateInvoiceCommand toCommandFromResource(CreateInvoiceResource resource){
        return new CreateInvoiceCommand(
                resource.numero(),
                resource.fecha_emision(),
                resource.fecha_pago(),
                resource.retencion(),
                resource.total_facturado(),
                resource.dias_anio(),
                resource.plazo_tasa(),
                resource.tasa_nominal(),
                resource.tasa_efectiva(),
                resource.periodo_capitalizacion(),
                resource.fecha_descuento(),
                resource.Moneda()
        );
    }
}
