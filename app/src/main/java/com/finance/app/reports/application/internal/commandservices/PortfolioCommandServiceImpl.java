package com.finance.app.reports.application.internal.commandservices;

import com.finance.app.reports.domain.services.PortfolioCommandService;
import com.finance.app.reports.infrastructure.persistence.jpa.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioCommandServiceImpl implements PortfolioCommandService {
    private final PortfolioRepository portfolioRepository;
    public PortfolioCommandServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
}
