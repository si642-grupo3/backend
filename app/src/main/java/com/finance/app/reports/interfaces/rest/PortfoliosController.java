package com.finance.app.reports.interfaces.rest;

import com.finance.app.reports.domain.model.queries.GetAllPortfoliosQuery;
import com.finance.app.reports.domain.model.queries.GetPortfolioByIdQuery;
import com.finance.app.reports.domain.services.PortfolioCommandService;
import com.finance.app.reports.domain.services.PortfolioQueryService;
import com.finance.app.reports.interfaces.rest.resources.CreatePortfolioResource;
import com.finance.app.reports.interfaces.rest.resources.PortfolioResource;
import com.finance.app.reports.interfaces.rest.transform.CreatePortfolioCommandFromResourceAssembler;
import com.finance.app.reports.interfaces.rest.transform.PortfolioResourceFromEntityAssembler;
import com.finance.app.users.interfaces.rest.resources.ClientResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cartera", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Carteras", description = "Cartera endpoints")
public class PortfoliosController {

    private final PortfolioQueryService portfolioQueryService;
    private final PortfolioCommandService portfolioCommandService;

    public PortfoliosController(PortfolioQueryService portfolioQueryService, PortfolioCommandService portfolioCommandService) {
        this.portfolioQueryService = portfolioQueryService;
        this.portfolioCommandService = portfolioCommandService;
    }

    @GetMapping
    public ResponseEntity<List<PortfolioResource>> getPortfolios() {
        var getAllPortfoliosQuery = new GetAllPortfoliosQuery();
        var portfolios = portfolioQueryService.handle(getAllPortfoliosQuery);
        var portfolioResources = portfolios.stream().map(PortfolioResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(portfolioResources);
    }

    @PostMapping
    public ResponseEntity<PortfolioResource> createPortfolio(@RequestBody CreatePortfolioResource resource){
        var createPortfolioCommand = CreatePortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        var portfolioId = portfolioCommandService.handle(createPortfolioCommand);
        if (portfolioId == 0L){
            return ResponseEntity.badRequest().build();
        }
        //add query
        var getPortfolioByIdQuery = new GetPortfolioByIdQuery(portfolioId);
        var portfolio = portfolioQueryService.handle(getPortfolioByIdQuery);

        if (portfolio.isEmpty()){
            return ResponseEntity.badRequest().build();
        }


        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(portfolio.get());
        return new ResponseEntity<>(portfolioResource, HttpStatus.CREATED);
    }


}
