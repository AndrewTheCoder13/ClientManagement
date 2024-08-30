package org.example.clientmanagement.response;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.example.clientmanagement.data.ContactType;

@Jacksonized
@Builder(setterPrefix = "with")
@Getter
public class ContactDTO {
    private ContactType type;
    private String value;

}