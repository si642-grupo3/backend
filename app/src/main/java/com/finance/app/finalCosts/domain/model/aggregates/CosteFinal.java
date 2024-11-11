package com.finance.app.finalCosts.domain.model.aggregates;

import com.finance.app.finalCosts.domain.model.commands.CreateFinalCostCommand;
import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CosteFinal extends AuditableAbstractAggregateRoot<CosteFinal> {

    @Getter
    private String motivo;

    @Getter
    private Float valor_efectivo;

    @Getter
    private Float valor_porcentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public CosteFinal() {
    }

    public CosteFinal(CreateFinalCostCommand command, InvoiceRepository invoiceRepository) {
        this.motivo = command.motivo();
        this.valor_efectivo = command.valor_efectivo();
        this.valor_porcentaje = command.valor_porcentaje();
        this.factura = invoiceRepository.findById(command.factura_id())
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
    }
}
