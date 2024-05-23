package it.epicode.lezione_api.service;

import it.epicode.lezione_api.dto.StudenteDto;
import it.epicode.lezione_api.exceptions.StudenteNonTrovatoException;
import it.epicode.lezione_api.model.Studente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class StudenteServiceList {
//    private List<Studente> studenti = new ArrayList<>();
//
//    public Optional<Studente> getStudenteByMatricola(int matricola) {
//        return studenti.stream().filter(s -> s.getMatricola() == matricola).findFirst();
//    }
//
//    public List<Studente> getAllStudenti() {
//        return studenti;
//    }
//
//    public String saveStudente(StudenteDto s) {
//        studenti.add(s);
//        return "Studente creato con questa matricola: " + s.getMatricola();
//    }
//
//    public Studente updateStudente(int matricola, Studente studenteUpdate) throws StudenteNonTrovatoException {
//        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
//
//        if (studenteOpt.isPresent()) {
//            Studente studente = studenteOpt.get();
//            studente.setNome(studenteUpdate.getNome());
//            studente.setCognome(studenteUpdate.getCognome());
//            studente.setDataNascita(studenteUpdate.getDataNascita());
//            return studente;
//        }
//        else {
//            throw new StudenteNonTrovatoException("Studente non trovato");
//        }
//    }
//
//    public String deleteStudente (int matricola) throws StudenteNonTrovatoException {
//        Optional<Studente> studenteOpt = getStudenteByMatricola(matricola);
//
//        if (studenteOpt.isPresent()) {
//            studenti.remove(studenteOpt.get());
//            return "Studente eliminato";
//        }
//        else {
//            throw new StudenteNonTrovatoException("Studente non trovato");
//        }
//    }

}

