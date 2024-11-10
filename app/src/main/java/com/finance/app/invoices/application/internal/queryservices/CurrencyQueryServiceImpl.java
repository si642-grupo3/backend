package com.finance.app.invoices.application.internal.queryservices;

import com.finance.app.invoices.domain.model.entities.Moneda;
import com.finance.app.invoices.domain.model.queries.GetAllCurrenciesQuery;
import com.finance.app.invoices.domain.services.CurrencyQueryService;
import com.finance.app.invoices.infrastructure.persistence.jpa.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyQueryServiceImpl implements CurrencyQueryService {

    private final CurrencyRepository currencyRepository;

    public CurrencyQueryServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Moneda> handle (GetAllCurrenciesQuery query) {
        return currencyRepository.findAll();
    }

}
