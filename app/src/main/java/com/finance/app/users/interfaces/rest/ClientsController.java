package com.finance.app.users.interfaces.rest;

import com.finance.app.users.domain.model.queries.GetAllClientsQuery;
import com.finance.app.users.domain.model.queries.GetClientByEmailAndPasswordQuery;
import com.finance.app.users.domain.model.queries.GetClientByIdQuery;
import com.finance.app.users.domain.services.ClientCommandService;
import com.finance.app.users.domain.services.ClientQueryService;
import com.finance.app.users.interfaces.rest.resources.ClientResource;
import com.finance.app.users.interfaces.rest.resources.CreateClientResource;
import com.finance.app.users.interfaces.rest.transform.ClientResourceFromEntityAssembler;
import com.finance.app.users.interfaces.rest.transform.CreateClientCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Clientes", description = "Clientes Endpoint")
public class ClientsController {

    private final ClientCommandService clientCommandService;
    private final ClientQueryService clientQueryService;

    public ClientsController(ClientCommandService clientCommandService, ClientQueryService clientQueryService) {
        this.clientCommandService = clientCommandService;
        this.clientQueryService = clientQueryService;
    }

    @PostMapping("/register")
    public ResponseEntity<ClientResource> createClient(@RequestBody CreateClientResource resource) {
        var createClientCommand = CreateClientCommandFromResourceAssembler.toCommandFromResource(resource);
        var clientId = clientCommandService.handle(createClientCommand);
        if (clientId == 0L){
            return ResponseEntity.badRequest().build();
        }
        var getClienByIdQuery = new GetClientByIdQuery(clientId);
        var client = clientQueryService.handle(getClienByIdQuery);

        if (client.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return new ResponseEntity<>(clientResource, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClientResource>> getAllClients(){
        var query = new GetAllClientsQuery();
        var clients = clientQueryService.handle(query);
        var clientResources = clients.stream().map(ClientResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(clientResources);
    }

    // get by id
    @GetMapping("/{id}")
    public ResponseEntity<ClientResource> getClientById(@PathVariable Long id){
        var query = new GetClientByIdQuery(id);
        var client = clientQueryService.handle(query);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return ResponseEntity.ok(clientResource);
    }

    // get by email and password
    @GetMapping("/login")
    public ResponseEntity<ClientResource> getClientByEmailAndPassword(@RequestParam String email, @RequestParam String password){
        var query = new GetClientByEmailAndPasswordQuery(email, password);
        var client = clientQueryService.handle(query);
        if (client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var clientResource = ClientResourceFromEntityAssembler.toResourceFromEntity(client.get());
        return ResponseEntity.ok(clientResource);
    }
}
