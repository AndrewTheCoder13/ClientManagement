package org.example.clientmanagement.service;

import org.example.clientmanagement.data.Client;
import org.example.clientmanagement.exception.client.ClientNotFound;
import org.example.clientmanagement.repo.ClientRepository;
import org.example.clientmanagement.request.CreateClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(CreateClientDTO createClientDTO) {
        Client client = new Client();
        client.setName(createClientDTO.getName());
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFound());
    }
}
