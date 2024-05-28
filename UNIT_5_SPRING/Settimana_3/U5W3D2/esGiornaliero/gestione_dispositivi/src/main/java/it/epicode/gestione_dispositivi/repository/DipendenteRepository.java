package it.epicode.gestione_dispositivi.repository;

import it.epicode.gestione_dispositivi.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    Optional<Dipendente> findByEmail(String email);
}
