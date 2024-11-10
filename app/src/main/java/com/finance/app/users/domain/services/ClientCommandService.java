package com.finance.app.users.domain.services;
import com.finance.app.users.domain.model.commands.CreateClientCommand;

public interface ClientCommandService {
    Long handle(CreateClientCommand command);
}
