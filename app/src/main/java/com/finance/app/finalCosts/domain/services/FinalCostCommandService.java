package com.finance.app.finalCosts.domain.services;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.domain.model.commands.CreateFinalCostCommand;
import com.finance.app.finalCosts.domain.model.commands.DeleteFinalCostCommand;

import java.util.Optional;

public interface FinalCostCommandService {
    Optional<CosteFinal> handle(CreateFinalCostCommand command);
    Optional<CosteFinal> handle(DeleteFinalCostCommand command);
}
