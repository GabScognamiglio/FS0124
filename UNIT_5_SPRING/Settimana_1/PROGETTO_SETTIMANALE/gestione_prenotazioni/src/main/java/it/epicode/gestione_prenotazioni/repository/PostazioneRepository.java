package it.epicode.gestione_prenotazioni.repository;

import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.bean.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {

    List<Postazione> findByTipoPostazione(TipoPostazione tipoPostazione);

    @Query("SELECT p from Postazione p WHERE p.edificio.citta = :citta")
    List<Postazione> cercaPostazioniPerCitta(String citta);

    @Query("SELECT p from Postazione p WHERE p.tipoPostazione = :tipo AND p.edificio.citta = :citta")
    List<Postazione> cercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta);
}
