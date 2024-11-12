package com.finance.app.reports.domain.services;

import com.finance.app.reports.domain.model.entities.Cartera;
import com.finance.app.reports.domain.model.queries.GetAllPortfoliosQuery;
import com.finance.app.reports.domain.model.queries.GetPortfolioByIdQuery;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PortfolioQueryService {
    List<Cartera> handle(GetAllPortfoliosQuery query);
    Optional<Cartera> handle(GetPortfolioByIdQuery query);
}
