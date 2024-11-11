package com.finance.app.initialCosts.domain.model.aggregates;

import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CosteInicial extends AuditableAbstractAggregateRoot<CosteInicial> {

    @Getter
    private String motivo;

    @Getter
    private Float valor_efectivo;

    @Getter
    private Float valor_porcentaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public CosteInicial() {
    }

    public CosteInicial(CreateInitialCostCommand command, InvoiceRepository invoiceRepository) {
        this.motivo = command.motivo();
        this.valor_efectivo = command.valor_efectivo();
        this.valor_porcentaje = command.valor_porcentaje();
        this.factura = invoiceRepository.findById(command.factura_id())
                .orElseThrow(() -> new EntityNotFoundException("Invoice not found"));
    }
}
