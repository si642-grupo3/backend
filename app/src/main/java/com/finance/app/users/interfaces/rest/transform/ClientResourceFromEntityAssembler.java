package com.finance.app.users.interfaces.rest.transform;

import com.finance.app.users.domain.model.aggregates.Cliente;
import com.finance.app.users.interfaces.rest.resources.ClientResource;

public class ClientResourceFromEntityAssembler {
    public static ClientResource toResourceFromEntity(Cliente entity){
        return new ClientResource(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getRuc(),
                entity.getTelefono(),
                entity.getDireccion(),
                entity.getEmail(),
                entity.getPassword()
        );
    }
}
