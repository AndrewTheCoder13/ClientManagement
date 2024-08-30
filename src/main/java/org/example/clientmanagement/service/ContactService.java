package org.example.clientmanagement.service;

import org.example.clientmanagement.data.Client;
import org.example.clientmanagement.data.Contact;
import org.example.clientmanagement.data.ContactType;
import org.example.clientmanagement.exception.client.ClientNotFound;
import org.example.clientmanagement.repo.ClientRepository;
import org.example.clientmanagement.repo.ContactRepository;
import org.example.clientmanagement.request.CreateContactDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Contact addContact(Long clientId, CreateContactDTO createContactDTO) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFound());
        Contact contact = new Contact();
        contact.setClient(client);
        contact.setType(createContactDTO.getType());
        contact.setValue(createContactDTO.getValue());
        return contactRepository.save(contact);
    }

    public List<Contact> getContactsByClientId(Long clientId) {
        return contactRepository.findByClientId(clientId);
    }

    public List<Contact> getContactsByClientIdAndType(Long clientId, ContactType type) {
        return contactRepository.findByClientIdAndType(clientId, type);
    }
}
