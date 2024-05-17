package it.epicode.gestione_prenotazioni.service;

import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.bean.enums.TipoPostazione;
import it.epicode.gestione_prenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public void cancellaPostazione(int id) {
        postazioneRepository.deleteById(id);
    }

    public Postazione getPostazioneById(int id) {
        return postazioneRepository.findById(id).get();
    }

    public List<Postazione> cercaPostazioniPerTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipoPostazione(tipo);
    }

    public List<Postazione> cercaPostazioniPerCitta(String citta) {
        return postazioneRepository.cercaPostazioniPerCitta(citta);
    }

    public List<Postazione> cercaPostazioniPerTipoECitta(TipoPostazione tipo, String citta){
        return postazioneRepository.cercaPostazioniPerTipoECitta(tipo, citta);
    }
}
