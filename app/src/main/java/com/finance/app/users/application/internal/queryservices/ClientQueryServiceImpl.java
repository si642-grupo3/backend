package com.finance.app.users.application.internal.queryservices;

import com.finance.app.users.domain.model.aggregates.Cliente;
import com.finance.app.users.domain.model.queries.GetAllClientsQuery;
import com.finance.app.users.domain.model.queries.GetClientByEmailAndPasswordQuery;
import com.finance.app.users.domain.model.queries.GetClientByIdQuery;
import com.finance.app.users.domain.services.ClientQueryService;
import com.finance.app.users.infrastructure.persistance.jpa.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientQueryServiceImpl implements ClientQueryService{

    private final ClientRepository clientRepository;

    public ClientQueryServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Cliente> handle(GetClientByIdQuery query) {
        return clientRepository.findById(query.ClientId());
    }

    @Override
    public Optional<Cliente> handle(GetClientByEmailAndPasswordQuery query) {
        return clientRepository.findByEmailAndPassword(query.email(), query.password());
    }

    @Override
    public List<Cliente> handle(GetAllClientsQuery query) {
        return clientRepository.findAll();
    }
}
