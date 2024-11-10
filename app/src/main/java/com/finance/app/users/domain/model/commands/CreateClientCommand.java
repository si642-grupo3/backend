package com.finance.app.users.domain.model.commands;

public record CreateClientCommand(
        String nombre,
        String apellido,
        String ruc,
        String telefono,
        String direccion,
        String email,
        String password
) {
}
