package com.finance.app.initialCosts.interfaces.rest;

import com.finance.app.initialCosts.domain.model.aggregates.CosteInicial;
import com.finance.app.initialCosts.domain.model.commands.DeleteInitialCostCommand;
import com.finance.app.initialCosts.domain.model.queries.GetAllInitialCostsQuery;
import com.finance.app.initialCosts.domain.services.InitialCostCommandService;
import com.finance.app.initialCosts.domain.services.InitialCostQueryService;
import com.finance.app.initialCosts.interfaces.rest.resources.CreateInitialCostResource;
import com.finance.app.initialCosts.interfaces.rest.resources.InitialCostResource;
import com.finance.app.initialCosts.interfaces.rest.transform.CreateInitialCostCommandFromResourceAssembler;
import com.finance.app.initialCosts.interfaces.rest.transform.InitialCostResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/coste_inicial", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Costes Inciales", description = "Costes Iniciales endpoints")
public class InitialCostController {

    private final InitialCostQueryService initialCostQueryService;
    private final InitialCostCommandService initialCostCommandService;

    public InitialCostController(InitialCostQueryService initialCostQueryService, InitialCostCommandService initialCostCommandService) {
        this.initialCostQueryService = initialCostQueryService;
        this.initialCostCommandService = initialCostCommandService;
    }

    @PostMapping
    public ResponseEntity<InitialCostResource> createInitialCost(@RequestBody CreateInitialCostResource resource){
        Optional<CosteInicial> initialCost =  initialCostCommandService.handle(CreateInitialCostCommandFromResourceAssembler.toCommandFromResource(resource));
        return initialCost.map(i -> new ResponseEntity<>(InitialCostResourceFromEntityAssembler.toResourceFromEntity(i), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<InitialCostResource>> getAllInitialCosts(){
        var initialCosts = initialCostQueryService.handle(new GetAllInitialCostsQuery());
        if(initialCosts.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var initialCostsResources = initialCosts.stream().map(InitialCostResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(initialCostsResources);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteInitialCost(@PathVariable Long id){
        try{
            var deleteInitialCostCommand = new DeleteInitialCostCommand(id);
            initialCostCommandService.handle(deleteInitialCostCommand);
            return ResponseEntity.ok("Initial cost deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
