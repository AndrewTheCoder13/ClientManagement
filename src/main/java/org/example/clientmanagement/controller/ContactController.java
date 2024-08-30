package org.example.clientmanagement.controller;

import org.example.clientmanagement.converter.ContactConverter;
import org.example.clientmanagement.data.ContactType;
import org.example.clientmanagement.request.CreateContactDTO;
import org.example.clientmanagement.response.ContactDTO;
import org.example.clientmanagement.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients/{clientId}/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactConverter contactConverter;

    @PostMapping
    public ResponseEntity<ContactDTO> addContact(@PathVariable Long clientId,
                                                 @RequestBody CreateContactDTO createContactDTO) {
        return ResponseEntity.ok(
                contactConverter.convert(
                        contactService.addContact(clientId, createContactDTO)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> getContacts(@PathVariable Long clientId) {
        return ResponseEntity.ok(
                contactConverter.convertList(
                        contactService.getContactsByClientId(clientId)
                )
        );
    }

    @GetMapping("/byType")
    public ResponseEntity<List<ContactDTO>> getContactsByType(@PathVariable Long clientId,
                                                              @RequestParam ContactType type) {
        return ResponseEntity.ok(
                contactConverter.convertList(
                        contactService.getContactsByClientIdAndType(clientId, type)
                )
        );
    }
}
