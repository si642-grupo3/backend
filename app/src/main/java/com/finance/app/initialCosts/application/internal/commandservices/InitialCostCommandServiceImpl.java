package com.finance.app.initialCosts.application.internal.commandservices;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.initialCosts.domain.model.commands.DeleteInitialCostCommand;
import com.finance.app.initialCosts.domain.services.InitialCostCommandService;
import com.finance.app.initialCosts.infrastructure.persistence.jpa.InitialCostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InitialCostCommandServiceImpl implements InitialCostCommandService {

    private final InitialCostRepository initialCostRepository;

    public InitialCostCommandServiceImpl(InitialCostRepository initialCostRepository) {
        this.initialCostRepository = initialCostRepository;
    }

    @Override
    public Optional<CosteInicial> handle(CreateInitialCostCommand command){
        var initialCost = new CosteInicial(command);
        var createdInitialCost = initialCostRepository.save(initialCost);
        return Optional.of(createdInitialCost);
    }

    @Override
    public Optional<CosteInicial> handle(DeleteInitialCostCommand command){
        var initialCost = initialCostRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Initial cost not found"));
        initialCostRepository.delete(initialCost);
        return Optional.of(initialCost);
    }
}
