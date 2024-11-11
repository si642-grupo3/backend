package com.finance.app.initialCosts.interfaces.rest.transform;

import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.initialCosts.interfaces.rest.resources.CreateInitialCostResource;

public class CreateInitialCostCommandFromResourceAssembler {

    public static CreateInitialCostCommand toCommandFromResource(CreateInitialCostResource resource) {
        return new CreateInitialCostCommand(
                resource.motivo(),
                resource.valor_efectivo(),
                resource.valor_porcentaje(),
                resource.factura_id()
        );
    }
}
