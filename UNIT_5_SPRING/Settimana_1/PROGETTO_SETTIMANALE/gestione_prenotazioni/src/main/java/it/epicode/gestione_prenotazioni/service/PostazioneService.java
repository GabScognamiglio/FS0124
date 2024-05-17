package it.epicode.gestione_prenotazioni.service;


import it.epicode.gestione_prenotazioni.bean.Edificio;
import it.epicode.gestione_prenotazioni.bean.Postazione;
import it.epicode.gestione_prenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaEdificio(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public List<Postazione> getAllPostazioni() {
        return postazioneRepository.findAll();
    }

    public void cancellaPostazione(int id) {
        postazioneRepository.deleteById(id);
    }
}
