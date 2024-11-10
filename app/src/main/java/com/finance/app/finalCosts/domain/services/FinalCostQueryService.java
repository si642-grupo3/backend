package com.finance.app.finalCosts.domain.services;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.domain.model.queries.GetAllFinalCostsQuery;

import java.util.List;

public interface FinalCostQueryService {
    List<CosteFinal> handle(GetAllFinalCostsQuery query);
}
