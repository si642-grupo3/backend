package com.finance.app.users.interfaces.rest.resources;

import com.finance.app.invoices.interfaces.rest.resources.InvoiceResource;

import java.util.List;

public record ClientResource(
        Long id,
        String nombre,
        String apellido,
        String ruc,
        String telefono,
        String direccin,
        String email,
        String password,
        List<InvoiceResource> facturas
) {
}
