package com.finance.app.reports.interfaces.rest.transform;

import com.finance.app.reports.domain.model.entities.Cartera;
import com.finance.app.reports.interfaces.rest.resources.PortfolioResource;

public class PortfolioResourceFromEntityAssembler {

    public static PortfolioResource toResourceFromEntity(Cartera entity){
        return new PortfolioResource(
                entity.getId(),
                entity.getFechaDescuento(),
                entity.getTceaCartera(),
                entity.getReporteId()
        );
    }
}
