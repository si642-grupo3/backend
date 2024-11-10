package com.finance.app.invoices.domain.model.queries;

public record GetInvoiceByIdQuery(Long id) {
    public GetInvoiceByIdQuery{
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }
    }
}
