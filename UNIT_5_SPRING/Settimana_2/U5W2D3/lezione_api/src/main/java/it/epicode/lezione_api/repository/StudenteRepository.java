package it.epicode.lezione_api.repository;

import it.epicode.lezione_api.model.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {
}
