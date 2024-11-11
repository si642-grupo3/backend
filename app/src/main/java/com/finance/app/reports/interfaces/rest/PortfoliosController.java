package com.finance.app.reports.interfaces.rest;

import com.finance.app.reports.domain.model.queries.GetAllPortfoliosQuery;
import com.finance.app.reports.domain.services.PortfolioQueryService;
import com.finance.app.reports.interfaces.rest.resources.PortfolioResource;
import com.finance.app.reports.interfaces.rest.transform.PortfolioResourceFromEntityAssembler;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cartera", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Carteras", description = "Cartera endpoints")
public class PortfoliosController {

    private final PortfolioQueryService portfolioQueryService;

    public PortfoliosController(PortfolioQueryService portfolioQueryService) {
        this.portfolioQueryService = portfolioQueryService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioResource>> getPortfolios() {
        var getAllPortfoliosQuery = new GetAllPortfoliosQuery();
        var portfolios = portfolioQueryService.handle(getAllPortfoliosQuery);
        var portfolioResources = portfolios.stream().map(PortfolioResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(portfolioResources);
    }
}
