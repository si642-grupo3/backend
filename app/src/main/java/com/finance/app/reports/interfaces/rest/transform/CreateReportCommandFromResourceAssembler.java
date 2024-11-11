package com.finance.app.reports.interfaces.rest.transform;

import com.finance.app.reports.domain.model.commands.CreateReportCommand;
import com.finance.app.reports.interfaces.rest.resources.CreateReportResource;

import java.util.Date;

public class CreateReportCommandFromResourceAssembler {

    public static CreateReportCommand toCommandFromResource(CreateReportResource resource){
        return new CreateReportCommand(
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