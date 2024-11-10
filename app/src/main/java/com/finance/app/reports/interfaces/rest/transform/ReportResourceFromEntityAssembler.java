package com.finance.app.reports.interfaces.rest.transform;

import com.finance.app.reports.domain.model.aggregates.Reporte;
import com.finance.app.reports.interfaces.rest.resources.ReportResource;

import java.util.Date;

public class ReportResourceFromEntityAssembler {

    public static ReportResource toResourceFromEntity(Reporte entity){
        return new ReportResource(
            entity.getId(),
            entity.getFechaGiro(),
            entity.getFechaVencimiento(),
            entity.getDiasTranscurridos(),
            entity.getValorNominal(),
            entity.getRetencion(),
            entity.getTasaEfectiva(),
            entity.getTasaDescuento(),
            entity.getDescuento(),
            entity.getCosteInicial(),
            entity.getCosteFinal(),
            entity.getValorNeto(),
            entity.getValorRecibido(),
            entity.getValorEntregado(),
            entity.getTcea(),
            entity.getFacturaId()
        );
    }
}
