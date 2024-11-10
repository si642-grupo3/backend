package com.finance.app.invoices.interfaces.rest.transform;

import com.finance.app.invoices.domain.model.entities.Moneda;
import com.finance.app.invoices.interfaces.rest.resources.CurrencyResource;

public class CurrencyResourceFromEntityAssembler {

    public static CurrencyResource toResourceFromEntity(Moneda entity){
        return new CurrencyResource(entity.getId(), entity.getNombre(), entity.getTipo_cambio());
    }
}
