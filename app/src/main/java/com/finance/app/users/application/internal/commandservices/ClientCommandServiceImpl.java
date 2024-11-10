package com.finance.app.users.application.internal.commandservices;

import com.finance.app.users.domain.model.aggregates.Cliente;
import com.finance.app.users.domain.model.commands.CreateClientCommand;
import com.finance.app.users.domain.services.ClientCommandService;
import com.finance.app.users.infrastructure.persistance.jpa.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    private final ClientRepository clientRepository;

    public ClientCommandServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // add verification of existing client
    @Override
    public Long handle(CreateClientCommand command) {
        var client = new Cliente(command.nombre(), command.apellido(), command.ruc(), command.telefono(), command.direccion(), command.email(), command.password());
        clientRepository.save(client);
        return client.getId();
    }
}
