package com.finance.app.invoices.interfaces.rest.transform;

import com.finance.app.finalCosts.interfaces.rest.resources.FinalCostResource;
import com.finance.app.initialCosts.interfaces.rest.resources.InitialCostResource;
import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.interfaces.rest.resources.InvoiceResource;

import java.util.List;

public class InvoiceResourceFromEntityAssembler {

    public static InvoiceResource toResourceFromEntity(Factura entity){

        List<InitialCostResource> costesIniciales = entity.getCostesIniciales().stream()
                .map(costeInicial -> new InitialCostResource(
                        costeInicial.getId(),
                        costeInicial.getMotivo(),
                        costeInicial.getValor_efectivo(),
                        costeInicial.getValor_porcentaje(),
                        costeInicial.getFactura().getId()
                ))
                .toList();

        List<FinalCostResource> costesFinales = entity.getCostesFinales().stream()
                .map(costeFinal -> new FinalCostResource(
                        costeFinal.getId(),
                        costeFinal.getMotivo(),
                        costeFinal.getValor_efectivo(),
                        costeFinal.getValor_porcentaje(),
                        costeFinal.getFactura().getId()
                ))
                .toList();

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
                entity.getMoneda(),
                costesIniciales,
                costesFinales,
                entity.getCliente().getId()
        );
    }
}
