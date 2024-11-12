package com.finance.app.reports.domain.services;

import com.finance.app.reports.domain.model.commands.CreatePortfolioCommand;

public interface PortfolioCommandService {
    Long handle(CreatePortfolioCommand command);
}
