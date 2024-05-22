package it.epicode.es_giornaliero.service;

import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.model.Autore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AutoreService {
    private List<Autore> autori = new ArrayList<>();

    public List<Autore> getAllAutori() {
        return autori;
    }

    public Optional<Autore> getAutoreById(int id) {
        return autori.stream().filter(s -> s.getId() == id).findFirst();
    }

    public String saveAutore(Autore autore) {
        autori.add(autore);
        return "Autore creato con questa id: " + autore.getId();
    }

    public Autore updateAutore(int matricola, Autore autoreUpdate) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(matricola);

        if (autoreOpt.isPresent()) {
            Autore autore = autoreOpt.get();
            autore.setNome(autoreUpdate.getNome());
            autore.setCognome(autoreUpdate.getCognome());
            autore.setDataNascita(autoreUpdate.getDataNascita());
            return autore;
        }
        else {
            throw new AutoreNonTrovatoException("Autore non trovato") ;
        }
    }

    public String deleteAutore (int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOpt = getAutoreById(id);

        if (autoreOpt.isPresent()) {
            autori.remove(autoreOpt.get());
            return "Autore eliminato";
        }
        else {
            throw new AutoreNonTrovatoException("Autore non trovato") ;
        }
    }
}
