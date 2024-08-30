package org.example.clientmanagement.request;

import lombok.Data;
import org.example.clientmanagement.data.ContactType;

@Data
public class CreateContactDTO {
    private ContactType type;
    private String value;
}
