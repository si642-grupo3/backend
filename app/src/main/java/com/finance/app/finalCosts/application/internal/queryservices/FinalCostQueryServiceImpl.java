package com.finance.app.finalCosts.application.internal.queryservices;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.domain.model.queries.GetAllFinalCostsQuery;
import com.finance.app.finalCosts.domain.services.FinalCostQueryService;
import com.finance.app.finalCosts.infrastructure.persistence.jpa.FinalCostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalCostQueryServiceImpl implements FinalCostQueryService {

    private final FinalCostRepository finalCostRepository;

    public FinalCostQueryServiceImpl(FinalCostRepository finalCostRepository) {
        this.finalCostRepository = finalCostRepository;
    }

    @Override
    public List<CosteFinal> handle(GetAllFinalCostsQuery query){
        return finalCostRepository.findAll();
    }
}
