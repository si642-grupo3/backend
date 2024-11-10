package com.finance.app.invoices.interfaces.rest;

import com.finance.app.invoices.domain.model.queries.GetAllCurrenciesQuery;
import com.finance.app.invoices.domain.services.CurrencyQueryService;
import com.finance.app.invoices.interfaces.rest.resources.CurrencyResource;
import com.finance.app.invoices.interfaces.rest.transform.CurrencyResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/monedas", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Monedas", description = "Moneda endpoints")
public class CurrenciesController {
    private final CurrencyQueryService currencyQueryService;

    public CurrenciesController(CurrencyQueryService currencyQueryService) {
        this.currencyQueryService = currencyQueryService;
    }

    @GetMapping
    public ResponseEntity<List<CurrencyResource>> getAllCurrencies() {
        var getAllCurrenciesQuery = new GetAllCurrenciesQuery();
        var currencies = currencyQueryService.handle(getAllCurrenciesQuery);
        var currencyResources = currencies.stream().map(CurrencyResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(currencyResources);
    }
}
