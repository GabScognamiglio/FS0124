package it.epicode.gestione_prenotazioni.repository;

import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.bean.Prenotazione;
import it.epicode.gestione_prenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    //per controllare se esiste già una prenotazione per un giorno specifico in una postazione specifica
    Optional<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate dataPrenotazione);

    //per controllare che un utente non abbia più di una prenotazione in una data specifica
    Optional<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
}
