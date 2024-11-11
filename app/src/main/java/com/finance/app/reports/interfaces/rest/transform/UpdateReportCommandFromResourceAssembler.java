package com.finance.app.reports.interfaces.rest.transform;

import com.finance.app.reports.domain.model.commands.UpdateReportCommand;
import com.finance.app.reports.interfaces.rest.resources.UpdateReportResource;

public class UpdateReportCommandFromResourceAssembler {

    public static UpdateReportCommand toCommandFromResource(Long id, UpdateReportResource resource){
        return new UpdateReportCommand(
                id,
                resource.fechaGiro(),
                resource.fechaVencimiento(),
                resource.diasTranscurridos(),
                resource.valorNominal(),
                resource.retencion(),
                resource.tasaEfectiva(),
                resource.tasaDescuento(),
                resource.descuento(),
                resource.costeInicial(),
                resource.costeFinal(),
                resource.valorNeto(),
                resource.valorRecibido(),
                resource.valorEntregado(),
                resource.tcea(),
                resource.factura_id(),
                resource.cartera_id()
        );
    }
}
