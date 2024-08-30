package org.example.clientmanagement.repo;

import org.example.clientmanagement.data.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
