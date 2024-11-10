package com.finance.app.finalCosts.domain.model.aggregates;

import com.finance.app.finalCosts.domain.model.commands.CreateFinalCostCommand;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
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

    public CosteFinal() {
    }

    public CosteFinal(CreateFinalCostCommand command) {
        this.motivo = command.motivo();
        this.valor_efectivo = command.valor_efectivo();
        this.valor_porcentaje = command.valor_porcentaje();
    }
}
