package com.finance.app.users.interfaces.rest.transform;

import com.finance.app.users.domain.model.commands.CreateClientCommand;
import com.finance.app.users.interfaces.rest.resources.CreateClientResource;

public class CreateClientCommandFromResourceAssembler {
    public static CreateClientCommand toCommandFromResource(CreateClientResource resource){
        return new CreateClientCommand(
                resource.nombre(),
                resource.apellido(),
                resource.ruc(),
                resource.telefono(),
                resource.direccin(),
                resource.email(),
                resource.password()
        );
    }
}
