package com.finance.app.invoices.domain.services;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.domain.model.commands.CreateInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.DeleteInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.UpdateInvoiceCommand;

import java.util.Optional;

public interface InvoiceCommandService {
    Optional<Factura> handle(CreateInvoiceCommand command);
    Optional<Factura> handle(UpdateInvoiceCommand command);
    Optional<Factura> handle(DeleteInvoiceCommand command);
}
