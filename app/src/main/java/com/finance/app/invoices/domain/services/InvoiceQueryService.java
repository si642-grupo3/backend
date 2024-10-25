package com.finance.app.invoices.domain.services;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.domain.model.queries.GetAllInvoicesQuery;
import com.finance.app.invoices.domain.model.queries.GetInvoiceByIdQuery;

import java.util.List;
import java.util.Optional;

public interface InvoiceQueryService {
    List<Factura> handle(GetAllInvoicesQuery query);
    Optional<Factura> handle (GetInvoiceByIdQuery query);
}
