package org.example.clientmanagement.repo;

import org.example.clientmanagement.data.Contact;
import org.example.clientmanagement.data.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByClientId(Long clientId);
    List<Contact> findByClientIdAndType(Long clientId, ContactType type);
}
