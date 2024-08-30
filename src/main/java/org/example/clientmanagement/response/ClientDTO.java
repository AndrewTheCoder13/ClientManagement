package org.example.clientmanagement.response;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder(setterPrefix = "with")
@Getter
public class ClientDTO {
    private String name;
    private List<ContactDTO> contacts;

}
