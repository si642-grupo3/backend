package com.finance.app.initialCosts.domain.services;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.initialCosts.domain.model.commands.DeleteInitialCostCommand;

import java.util.Optional;

public interface InitialCostCommandService {
    Optional<CosteInicial> handle(CreateInitialCostCommand command);
    Optional<CosteInicial> handle(DeleteInitialCostCommand command);
}
