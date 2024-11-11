package com.finance.app.initialCosts.application.internal.commandservices;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.initialCosts.domain.model.commands.DeleteInitialCostCommand;
import com.finance.app.initialCosts.domain.services.InitialCostCommandService;
import com.finance.app.initialCosts.infrastructure.persistence.jpa.InitialCostRepository;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InitialCostCommandServiceImpl implements InitialCostCommandService {

    private final InitialCostRepository initialCostRepository;
    private final InvoiceRepository invoiceRepository;

    public InitialCostCommandServiceImpl(InitialCostRepository initialCostRepository, InvoiceRepository invoiceRepository) {
        this.initialCostRepository = initialCostRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Optional<CosteInicial> handle(CreateInitialCostCommand command){
        var initialCost = new CosteInicial(command, invoiceRepository);
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
