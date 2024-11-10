package com.finance.app.finalCosts.interfaces.rest;

import com.finance.app.finalCosts.domain.model.aggregates.CosteFinal;
import com.finance.app.finalCosts.domain.model.commands.DeleteFinalCostCommand;
import com.finance.app.finalCosts.domain.model.queries.GetAllFinalCostsQuery;
import com.finance.app.finalCosts.domain.services.FinalCostCommandService;
import com.finance.app.finalCosts.domain.services.FinalCostQueryService;
import com.finance.app.finalCosts.interfaces.rest.resources.CreateFinalCostResource;
import com.finance.app.finalCosts.interfaces.rest.resources.FinalCostResource;
import com.finance.app.finalCosts.interfaces.rest.transform.CreateFinalCostCommandFromResourceAssembler;
import com.finance.app.finalCosts.interfaces.rest.transform.FinalCostResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/v1/coste_final", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Costes Finales", description = "Costes Finales endpoints")
public class FinalCostController {

    private final FinalCostQueryService finalCostQueryService;
    private final FinalCostCommandService finalCostCommandService;

    public FinalCostController(FinalCostQueryService finalCostQueryService, FinalCostCommandService finalCostCommandService) {
        this.finalCostQueryService = finalCostQueryService;
        this.finalCostCommandService = finalCostCommandService;
    }

    @PostMapping
    public ResponseEntity<FinalCostResource> createFinalCost(@RequestBody CreateFinalCostResource resource){
        Optional<CosteFinal> finalCost =  finalCostCommandService.handle(CreateFinalCostCommandFromResourceAssembler.toCommandFromResource(resource));
        return finalCost.map(f -> new ResponseEntity<>(FinalCostResourceFromEntityAssembler.toResourceFromEntity(f), CREATED)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping
    public ResponseEntity<List<FinalCostResource>> getAllFinalCosts(){
        var finalCosts = finalCostQueryService.handle(new GetAllFinalCostsQuery());
        if(finalCosts.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var finalCostsResources = finalCosts.stream().map(FinalCostResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(finalCostsResources);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteFinalCost(@PathVariable Long id){
        try{
            var deleteFinalCostCommand = new DeleteFinalCostCommand(id);
            finalCostCommandService.handle(deleteFinalCostCommand);
            return ResponseEntity.ok("Final cost deleted successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
