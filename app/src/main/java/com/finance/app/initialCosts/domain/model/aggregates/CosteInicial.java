package com.finance.app.initialCosts.domain.model.aggregates;

import com.finance.app.initialCosts.domain.model.commands.CreateInitialCostCommand;
import com.finance.app.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
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

    public CosteInicial() {
    }

    public CosteInicial(CreateInitialCostCommand command) {
        this.motivo = command.motivo();
        this.valor_efectivo = command.valor_efectivo();
        this.valor_porcentaje = command.valor_porcentaje();
    }
}
