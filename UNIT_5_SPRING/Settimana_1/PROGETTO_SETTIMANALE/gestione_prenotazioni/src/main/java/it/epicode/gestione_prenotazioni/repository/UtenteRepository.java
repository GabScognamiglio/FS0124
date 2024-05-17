package it.epicode.gestione_prenotazioni.repository;

import it.epicode.gestione_prenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
}
