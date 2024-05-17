package it.epicode.gestione_prenotazioni.service;


import it.epicode.gestione_prenotazioni.bean.Utente;
import it.epicode.gestione_prenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void salvaUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public List<Utente> getAllUtenti() {
        return utenteRepository.findAll();
    }

    public void cancellaUtente(int id) {
        utenteRepository.deleteById(id);
    }
}
