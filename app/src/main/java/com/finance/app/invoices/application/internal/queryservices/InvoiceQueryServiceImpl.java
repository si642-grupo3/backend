package com.finance.app.invoices.application.internal.queryservices;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.domain.model.queries.GetAllInvoicesQuery;
import com.finance.app.invoices.domain.model.queries.GetInvoiceByIdQuery;
import com.finance.app.invoices.domain.services.InvoiceQueryService;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceQueryServiceImpl implements InvoiceQueryService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceQueryServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Factura> handle(GetAllInvoicesQuery query) {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Factura> handle(GetInvoiceByIdQuery query) {
        return invoiceRepository.findById(query.id());
    }
}
