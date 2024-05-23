package it.epicode.es_giornaliero.repository;

import it.epicode.es_giornaliero.model.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoreRepository extends JpaRepository<Autore, Integer> {
}
