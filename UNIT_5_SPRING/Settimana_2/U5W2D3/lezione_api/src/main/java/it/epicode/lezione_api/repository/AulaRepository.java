package it.epicode.lezione_api.repository;

import it.epicode.lezione_api.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer> {
}
