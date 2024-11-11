package com.finance.app.finalCosts.application.internal.commandservices;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.domain.model.commands.CreateFinalCostCommand;
import com.finance.app.finalCosts.domain.model.commands.DeleteFinalCostCommand;
import com.finance.app.finalCosts.domain.services.FinalCostCommandService;
import com.finance.app.finalCosts.infrastructure.persistence.jpa.FinalCostRepository;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinalCostCommandServiceImpl implements FinalCostCommandService {

    private final FinalCostRepository finalCostRepository;
    private final InvoiceRepository invoiceRepository;

    public FinalCostCommandServiceImpl(FinalCostRepository finalCostRepository, InvoiceRepository invoiceRepository) {
        this.finalCostRepository = finalCostRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Optional<CosteFinal> handle(CreateFinalCostCommand command){
        var finalCost = new CosteFinal(command, invoiceRepository);
        var createdFinalCost = finalCostRepository.save(finalCost);
        return Optional.of(createdFinalCost);
    }

    @Override
    public Optional<CosteFinal> handle(DeleteFinalCostCommand command){
        var finalCost = finalCostRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Final cost not found"));
        finalCostRepository.delete(finalCost);
        return Optional.of(finalCost);
    }
}
