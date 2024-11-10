package com.finance.app.finalCosts.interfaces.rest.transform;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.interfaces.rest.resources.FinalCostResource;

public class FinalCostResourceFromEntityAssembler {
    public static FinalCostResource toResourceFromEntity(CosteFinal entity) {
        return new FinalCostResource(
                entity.getId(),
                entity.getMotivo(),
                entity.getValor_efectivo(),
                entity.getValor_porcentaje()
        );
    }
}
