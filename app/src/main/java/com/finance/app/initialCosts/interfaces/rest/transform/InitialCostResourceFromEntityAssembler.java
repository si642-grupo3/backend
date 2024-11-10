package com.finance.app.initialCosts.interfaces.rest.transform;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.interfaces.rest.resources.InitialCostResource;

public class InitialCostResourceFromEntityAssembler {
    public static InitialCostResource toResourceFromEntity(CosteInicial entity) {
        return new InitialCostResource(
                entity.getId(),
                entity.getMotivo(),
                entity.getValor_efectivo(),
                entity.getValor_porcentaje()
        );
    }
}
