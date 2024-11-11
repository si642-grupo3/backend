package com.finance.app.invoices.application.internal.commandservices;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.domain.model.commands.CreateInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.DeleteInvoiceCommand;
import com.finance.app.invoices.domain.model.commands.UpdateInvoiceCommand;
import com.finance.app.invoices.domain.services.InvoiceCommandService;
import com.finance.app.invoices.infrastructure.persistence.jpa.CurrencyRepository;
import com.finance.app.invoices.infrastructure.persistence.jpa.InvoiceRepository;
import com.finance.app.users.infrastructure.persistance.jpa.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceCommandServiceImpl implements InvoiceCommandService {

    private final InvoiceRepository invoiceRepository;
    private final CurrencyRepository currencyRepository;
    private final ClientRepository clientRepository;

    public InvoiceCommandServiceImpl(InvoiceRepository invoiceRepository, CurrencyRepository currencyRepository, ClientRepository clientRepository) {
        this.invoiceRepository = invoiceRepository;
        this.currencyRepository = currencyRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Factura> handle(CreateInvoiceCommand command){
        if(invoiceRepository.existsByNumero(command.numero())){
            throw new IllegalArgumentException("Factura with same number already exists");
        }
        var invoice = new Factura(command, currencyRepository, clientRepository);
        var createdInvoice = invoiceRepository.save(invoice);
        return Optional.of(createdInvoice);
    }

    @Override
    public Optional<Factura> handle(UpdateInvoiceCommand command){
        var invoice = invoiceRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Factura not found"));
        invoice.UpdateInvoice(command, currencyRepository);
        var updatedInvoice = invoiceRepository.save(invoice);
        return Optional.of(updatedInvoice);
    }

    @Override
    public Optional<Factura> handle(DeleteInvoiceCommand command){
        var invoice = invoiceRepository.findById(command.id())
                .orElseThrow(() -> new IllegalArgumentException("Factura not found"));
        invoiceRepository.delete(invoice);
        return Optional.of(invoice);
    }
}
