package org.example.clientmanagement.controller;

import org.example.clientmanagement.converter.ClientConverter;
import org.example.clientmanagement.request.CreateClientDTO;
import org.example.clientmanagement.response.ClientDTO;
import org.example.clientmanagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody CreateClientDTO createClientDTO) {
        return ResponseEntity.ok(
                clientConverter.convert(
                        clientService.createClient(createClientDTO)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        return ResponseEntity.ok(
                clientConverter.convertList(
                        clientService.getAllClients()
                )
        );
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(
                clientConverter.convert(
                        clientService.getClientById(clientId)
                )
        );
    }
}
