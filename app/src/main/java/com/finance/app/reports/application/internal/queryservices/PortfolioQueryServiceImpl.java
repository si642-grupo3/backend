package com.finance.app.reports.application.internal.queryservices;

import com.finance.app.reports.domain.model.entities.Cartera;
import com.finance.app.reports.domain.model.queries.GetAllPortfoliosQuery;
import com.finance.app.reports.domain.model.queries.GetPortfolioByIdQuery;
import com.finance.app.reports.domain.services.PortfolioQueryService;
import com.finance.app.reports.infrastructure.persistence.jpa.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioQueryServiceImpl implements PortfolioQueryService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioQueryServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public List<Cartera> handle(GetAllPortfoliosQuery query) {
        return portfolioRepository.findAll();
    }

    @Override
    public Optional<Cartera> handle(GetPortfolioByIdQuery query) {
        return portfolioRepository.findById(query.id());
    }

}
