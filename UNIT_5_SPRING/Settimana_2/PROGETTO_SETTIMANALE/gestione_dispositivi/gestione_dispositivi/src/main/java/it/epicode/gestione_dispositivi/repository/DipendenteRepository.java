package it.epicode.gestione_dispositivi.repository;

import it.epicode.gestione_dispositivi.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
}
