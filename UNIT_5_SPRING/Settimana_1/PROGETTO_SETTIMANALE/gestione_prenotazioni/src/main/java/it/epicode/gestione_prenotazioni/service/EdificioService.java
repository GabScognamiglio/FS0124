package it.epicode.gestione_prenotazioni.service;


import it.epicode.gestione_prenotazioni.bean.Edificio;
import it.epicode.gestione_prenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void salvaEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public List<Edificio> getAllEdifici() {
        return edificioRepository.findAll();
    }

    public void cancellaEdificio(int id) {
        edificioRepository.deleteById(id);
    }

    public Edificio getEdificioById(int id) {
        return edificioRepository.findById(id).get();
    }
}
