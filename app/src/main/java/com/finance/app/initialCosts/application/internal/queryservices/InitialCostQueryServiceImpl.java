package com.finance.app.initialCosts.application.internal.queryservices;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.queries.GetAllInitialCostsQuery;
import com.finance.app.initialCosts.domain.services.InitialCostQueryService;
import com.finance.app.initialCosts.infrastructure.persistence.jpa.InitialCostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitialCostQueryServiceImpl implements InitialCostQueryService {

    private final InitialCostRepository initialCostRepository;

    public InitialCostQueryServiceImpl(InitialCostRepository initialCostRepository) {
        this.initialCostRepository = initialCostRepository;
    }

    @Override
    public List<CosteInicial> handle(GetAllInitialCostsQuery query){
        return initialCostRepository.findAll();
    }
}
