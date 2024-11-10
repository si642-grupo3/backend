package com.finance.app.reports.domain.services;

import com.finance.app.reports.domain.model.entities.Cartera;
import com.finance.app.reports.domain.model.queries.GetAllPortfoliosQuery;

import java.util.List;

public interface PortfolioQueryService {
    List<Cartera> handle(GetAllPortfoliosQuery query);
}
