package com.finance.app.invoices.interfaces.rest.transform;

import com.finance.app.invoices.domain.model.commands.UpdateInvoiceCommand;
import com.finance.app.invoices.interfaces.rest.resources.UpdateInvoiceResource;

public class UpdateInvoiceCommandFromResourceAssembler {
    public static UpdateInvoiceCommand toCommandFromResource(Long id, UpdateInvoiceResource resource) {
        return new UpdateInvoiceCommand(
            id,
            resource.fecha_emision(),
            resource.fecha_pago(),
            resource.retencion(),
            resource.total_facturado(),
            resource.Moneda());
    }
}
