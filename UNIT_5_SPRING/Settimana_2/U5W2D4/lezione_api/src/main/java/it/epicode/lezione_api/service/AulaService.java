package it.epicode.lezione_api.service;

import it.epicode.lezione_api.dto.AulaDto;
import it.epicode.lezione_api.exceptions.AulaNonTrovataException;
import it.epicode.lezione_api.model.Aula;
import it.epicode.lezione_api.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;

    public String saveAula(AulaDto aulaDto) {
        Aula aula = new Aula();
        aula.setNome(aulaDto.getNome());
        aula.setPiano(aulaDto.getPiano());

        aulaRepository.save(aula);
        return "Aula con ID " + aula.getId() + " creata con successo.";
    }

    public List<Aula> getAule() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> getAulaById(int id) {
        return aulaRepository.findById(id);
    }

    public Aula updateAula(int id, AulaDto aulaDto) {
        Optional<Aula> aulaOptional = getAulaById(id);

        if (aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            aula.setNome(aulaDto.getNome());
            aula.setPiano(aulaDto.getPiano());

            aulaRepository.save(aula);
            return aula;
        }
        else {
            throw new AulaNonTrovataException("Aula con ID " + id + " non trovata.");
        }
    }

    public String deleteAula(int id) {
        Optional<Aula> aulaOptional = getAulaById(id);

        if (aulaOptional.isPresent()) {
            aulaRepository.delete(aulaOptional.get());
            return "Aula con ID " + id + " eliminata con successo.";
        }
        else {
            throw new AulaNonTrovataException("Aula con ID " + id + " non trovata.");
        }

    }
}
