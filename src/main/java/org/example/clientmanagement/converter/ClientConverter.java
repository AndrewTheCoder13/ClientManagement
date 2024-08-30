package org.example.clientmanagement.converter;

import org.example.clientmanagement.data.Client;
import org.example.clientmanagement.response.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    @Autowired
    private ContactConverter contactConverter;

    public List<ClientDTO> convertList(List<Client> clients){
        return clients.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public ClientDTO convert(Client client) {
        return ClientDTO.builder()
                .withName(client.getName())
                .withContacts(client.getContacts() == null?
                        null : client.getContacts().stream().map(contactConverter::convert).collect(Collectors.toList()))
                .build();

    }

}
