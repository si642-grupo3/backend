package com.finance.app.users.interfaces.rest.resources;

public record ClientResource(
        Long id,
        String nombre,
        String apellido,
        String ruc,
        String telefono,
        String direccin,
        String email,
        String password
) {
}
