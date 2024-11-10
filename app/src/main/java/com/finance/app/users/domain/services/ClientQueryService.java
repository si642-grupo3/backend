package com.finance.app.users.domain.services;
import com.finance.app.users.domain.model.aggregates.Cliente;
import com.finance.app.users.domain.model.queries.GetAllClientsQuery;
import com.finance.app.users.domain.model.queries.GetClientByEmailAndPasswordQuery;
import com.finance.app.users.domain.model.queries.GetClientByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ClientQueryService {
   Optional<Cliente> handle(GetClientByIdQuery query);
   Optional<Cliente> handle(GetClientByEmailAndPasswordQuery query);
   List<Cliente> handle(GetAllClientsQuery query);
}
