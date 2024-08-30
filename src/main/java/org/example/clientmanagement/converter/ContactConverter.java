package org.example.clientmanagement.converter;

import org.example.clientmanagement.data.Contact;
import org.example.clientmanagement.response.ContactDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactConverter {

    public List<ContactDTO> convertList(List<Contact> clients){
        return clients.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public ContactDTO convert(Contact contact) {
        return ContactDTO.builder()
                .withType(contact.getType())
                .withValue(contact.getValue())
                .build();
    }
}
