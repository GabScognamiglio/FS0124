package it.epicode.es_giornaliero.service;

import it.epicode.es_giornaliero.dto.AutoreDto;
import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.model.Autore;
import it.epicode.es_giornaliero.repository.AutoreRepository;
import it.epicode.es_giornaliero.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AutoreService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore(autoreDto.getNome(),autoreDto.getCognome(), autoreDto.getDataNascita());
       autoreRepository.save(autore);
       return "Autore con ID " + autore.getId() + " creato con successo.";
    }

    public Page<Autore> getAutori(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return autoreRepository.findAll(pageable);
    }

    public Optional<Autore> getAutoreById(int id) {
        return autoreRepository.findById(id);
    }


    public Autore updateAutore(int id, AutoreDto autoreDto) {
        Optional<Autore> autoreOptional = getAutoreById(id);

        if (autoreOptional.isPresent()) {
            Autore autore = autoreOptional.get();
            autore.setNome(autoreDto.getNome());
            autore.setCognome(autoreDto.getCognome());
            autore.setDataNascita(autoreDto.getDataNascita());

            autoreRepository.save(autore);
            return autore;
        }
        else {
            throw new AutoreNonTrovatoException("Autore con ID " + id + " non trovato.");
        }
    }

    public String deleteAutore (int id) {
        Optional<Autore> autoreOptional = getAutoreById(id);

        if (autoreOptional.isPresent()) {
            autoreRepository.delete(autoreOptional.get());
            return "Autore con id" + id + " eliminato con successo.";
        }
        else {
            throw new AutoreNonTrovatoException("Autore con id " + id + " non trovato");
        }
    }
}
