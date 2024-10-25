package com.finance.app.invoices.interfaces.rest;

import com.finance.app.invoices.domain.model.aggregates.Factura;
import com.finance.app.invoices.domain.model.commands.DeleteInvoiceCommand;
import com.finance.app.invoices.domain.model.queries.GetAllInvoicesQuery;
import com.finance.app.invoices.domain.model.queries.GetInvoiceByIdQuery;
import com.finance.app.invoices.domain.services.InvoiceCommandService;
import com.finance.app.invoices.domain.services.InvoiceQueryService;
import com.finance.app.invoices.interfaces.rest.resources.CreateInvoiceResource;
import com.finance.app.invoices.interfaces.rest.resources.InvoiceResource;
import com.finance.app.invoices.interfaces.rest.resources.UpdateInvoiceResource;
import com.finance.app.invoices.interfaces.rest.transform.CreateInvoiceCommandFromResourceAssembler;
import com.finance.app.invoices.interfaces.rest.transform.InvoiceResourceFromEntityAssembler;
import com.finance.app.invoices.interfaces.rest.transform.UpdateInvoiceCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/facturas", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Facturas", description = "Factura endpoints")
public class InvoicesController {

    private final InvoiceQueryService invoiceQueryService;
    private final InvoiceCommandService invoiceCommandService;

    public InvoicesController(InvoiceQueryService invoiceQueryService, InvoiceCommandService invoiceCommandService) {
        this.invoiceQueryService = invoiceQueryService;
        this.invoiceCommandService = invoiceCommandService;
    }

    @PostMapping
    public ResponseEntity<InvoiceResource> createInvoice(@RequestBody CreateInvoiceResource resource) {
        Optional<Factura> invoice = invoiceCommandService.handle(CreateInvoiceCommandFromResourceAssembler.toCommandFromResource(resource));
        return invoice.map(i-> new ResponseEntity<>(InvoiceResourceFromEntityAssembler.toResourceFromEntity(i), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<InvoiceResource>> getAllInvoices() {
        var invoices = invoiceQueryService.handle(new GetAllInvoicesQuery());
        if(invoices.isEmpty()) return ResponseEntity.notFound().build();
        var invoiceResources = invoices.stream().map(InvoiceResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(invoiceResources);
    }

    @GetMapping("{id}")
    public ResponseEntity<InvoiceResource> getInvoiceById(@PathVariable Long id){
        Optional<Factura> invoice = invoiceQueryService.handle(new GetInvoiceByIdQuery(id));
        return invoice.map(i -> ResponseEntity.ok(InvoiceResourceFromEntityAssembler.toResourceFromEntity(i))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /*private ResponseEntity<List<InvoiceResource>> getAllInvoicesByUserId(Long userId){
        var getAllInvoicesByUserIdQuery = new GetAllInvoicesByUserIdQuery(userId);
        var invoices = invoiceQueryService.handle(getAllInvoicesByUserIdQuery);
        if(invoices.isEmpty()) return ResponseEntity.notFound().build();
        var invoiceResources = invoices.stream().map(InvoiceResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(invoiceResources);
    }*/

    @PutMapping(value = "/{id}")
    public ResponseEntity<InvoiceResource> updateInvoice(@PathVariable Long id, @RequestBody UpdateInvoiceResource resource){
        var updateInvoiceCommand = UpdateInvoiceCommandFromResourceAssembler.toCommandFromResource(id, resource);
        invoiceCommandService.handle(updateInvoiceCommand);

        var getInvoiceByIdQuery = new GetInvoiceByIdQuery(id);
        var invoice = invoiceQueryService.handle(getInvoiceByIdQuery);
        if(invoice.isEmpty()) return ResponseEntity.notFound().build();
        var invoiceResource = InvoiceResourceFromEntityAssembler.toResourceFromEntity(invoice.get());
        return ResponseEntity.ok(invoiceResource);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id){
        try{
            var deleteInvoiceCommand = new DeleteInvoiceCommand(id);
            invoiceCommandService.handle(deleteInvoiceCommand);
            return ResponseEntity.ok("Invoice deleted successfully");
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
}
