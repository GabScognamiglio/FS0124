package it.epicode.gestione_prenotazioni.service;

import it.epicode.gestione_prenotazioni.bean.Prenotazione;
import it.epicode.gestione_prenotazioni.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;


    //prima della persistenza controlla che non vi sia una prenotazione con quella postazione in quella data
    // e che un utente non abbia già una prenotazione in quella data
    public void salvaPrenotazione(Prenotazione prenotazione) {
      if  (prenotazioneRepository.findByPostazioneAndDataPrenotazione(
                prenotazione.getPostazione(), prenotazione.getDataPrenotazione()).isEmpty() &&
              prenotazioneRepository.findByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione()).isEmpty()
      ){
          prenotazioneRepository.save(prenotazione);
      } else {
          throw new IllegalArgumentException("Esiste già una prenotazione per questa postazione nel giorno scelto");
      }

    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepository.findAll();
    }

    public void cancellaPrenotazione(int id) {
        prenotazioneRepository.deleteById(id);
    }

    public Prenotazione getPrenotazioneById(int id) {
        return prenotazioneRepository.findById(id).get();
    }
}
