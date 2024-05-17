package it.epicode.gestione_prenotazioni.repository;

import it.epicode.gestione_prenotazioni.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
