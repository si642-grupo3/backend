package com.finance.app.initialCosts.domain.services;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.queries.GetAllInitialCostsQuery;

import java.util.List;

public interface InitialCostQueryService {
    List<CosteInicial> handle(GetAllInitialCostsQuery query);
}
