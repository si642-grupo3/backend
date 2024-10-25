package com.finance.app.invoices.application.internal.commandservices;

import com.finance.app.invoices.domain.services.CurrencyCommandService;
import com.finance.app.invoices.infrastructure.persistence.jpa.CurrencyRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyCommandServiceImpl implements CurrencyCommandService {

    private final CurrencyRepository currencyRepository;

    public CurrencyCommandServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
}