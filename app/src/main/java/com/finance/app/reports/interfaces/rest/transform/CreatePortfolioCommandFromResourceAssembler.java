package com.finance.app.reports.interfaces.rest.transform;

import com.finance.app.reports.domain.model.commands.CreatePortfolioCommand;
import com.finance.app.reports.interfaces.rest.resources.CreatePortfolioResource;

public class CreatePortfolioCommandFromResourceAssembler {
    public static CreatePortfolioCommand toCommandFromResource(CreatePortfolioResource resource){
        return new CreatePortfolioCommand(
                resource.fechaDescuento(),
                resource.tceaCartera()
        );

    }
}
