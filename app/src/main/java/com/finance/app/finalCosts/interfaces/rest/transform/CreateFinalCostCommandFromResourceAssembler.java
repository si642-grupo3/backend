package com.finance.app.finalCosts.interfaces.rest.transform;

import com.finance.app.finalCosts.domain.model.commands.CreateFinalCostCommand;
import com.finance.app.finalCosts.interfaces.rest.resources.CreateFinalCostResource;

public class CreateFinalCostCommandFromResourceAssembler {

    public static CreateFinalCostCommand toCommandFromResource(CreateFinalCostResource resource) {
        return new CreateFinalCostCommand(
                resource.motivo(),
                resource.valor_efectivo(),
                resource.valor_porcentaje()
        );
    }
}
