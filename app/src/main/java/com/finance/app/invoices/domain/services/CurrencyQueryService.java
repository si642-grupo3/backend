package com.finance.app.invoices.domain.services;

import com.finance.app.invoices.domain.model.entities.Moneda;
import com.finance.app.invoices.domain.model.queries.GetAllCurrenciesQuery;

import java.util.List;

public interface CurrencyQueryService {
    List<Moneda> handle(GetAllCurrenciesQuery query);
}
