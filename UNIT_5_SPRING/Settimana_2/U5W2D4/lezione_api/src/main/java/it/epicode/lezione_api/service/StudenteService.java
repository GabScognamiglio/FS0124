package it.epicode.lezione_api.service;

import com.cloudinary.Cloudinary;
import it.epicode.lezione_api.dto.StudenteDto;
import it.epicode.lezione_api.exceptions.AulaNonTrovataException;
import it.epicode.lezione_api.exceptions.StudenteNonTrovatoException;
import it.epicode.lezione_api.model.Aula;
import it.epicode.lezione_api.model.Studente;
import it.epicode.lezione_api.repository.AulaRepository;
import it.epicode.lezione_api.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class StudenteService {

    @Autowired
    private StudenteRepository studenteRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveStudente(StudenteDto studenteDto) {
        Studente studente = new Studente();
        studente.setNome(studenteDto.getNome());
        studente.setCognome(studenteDto.getCognome());
        studente.setDataNascita(studenteDto.getDataNascita());
        studente.setEmail(studenteDto.getEmail());
        Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());

        if (aulaOptional.isPresent()) {
            Aula aula = aulaOptional.get();
            studente.setAula(aula);
            studenteRepository.save(studente);
            sendMail(studente.getEmail());
            return "Studente con matricola " + studente.getMatricola() + " salvato correttamente";
        } else {
            throw new AulaNonTrovataException("Aula con id: " + studenteDto.getAulaId() + " non trovata");
        }
    }


    public Page<Studente> getStudenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studenteRepository.findAll(pageable);
    }

    public Optional<Studente> getStudenteById(int matricola) {
        return studenteRepository.findById(matricola);
    }

    public Studente updateStudente(int matricola, StudenteDto studenteDto) {
        Optional<Studente> studenteOptional = getStudenteById(matricola);

        if (studenteOptional.isPresent()) {
            Studente studente = studenteOptional.get();

            studente.setNome(studenteDto.getNome());
            studente.setCognome(studenteDto.getCognome());
            studente.setDataNascita(studenteDto.getDataNascita());
            studente.setEmail(studenteDto.getEmail());
            Optional<Aula> aulaOptional = aulaRepository.findById(studenteDto.getAulaId());

            if (aulaOptional.isPresent()) {
                Aula aula = aulaOptional.get();
                studente.setAula(aula);
                studenteRepository.save(studente);
                return studente;
            } else {
                throw new AulaNonTrovataException("Aula con id: " + studenteDto.getAulaId() + " non trovata");
            }
        }
        else {
            throw new StudenteNonTrovatoException("Studente con matricola " + matricola + " non trovato");
        }
    }

    public String deleteStudente (int matricola) {
        Optional<Studente> studenteOptional = getStudenteById(matricola);

        if (studenteOptional.isPresent()) {
            studenteRepository.delete(studenteOptional.get());
            return "Studente con matricola" + matricola + " eliminato con successo.";
        }
        else {
            throw new StudenteNonTrovatoException("Studente con matricola " + matricola + " non trovato");
        }
    }

    public String patchFotoStudente (int matricola, MultipartFile img) throws IOException {
        Optional<Studente> studenteOptional = getStudenteById(matricola);

        if (studenteOptional.isPresent()) {
            String url =(String) cloudinary.uploader().upload(img.getBytes(), Collections.emptyMap()).get("url");
            Studente studente = studenteOptional.get();
            studente.setFoto(url);
            studenteRepository.save(studente);
            return "Studente con matricola" + matricola + " aggiornato correttamente con l'immagine: " + url;
        }
        else {
            throw new StudenteNonTrovatoException("Studente con matricola " + matricola + " non trovato");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Servizio rest");
        message.setText("Registrazione al servizio rest avvenuta con successo");

        javaMailSender.send(message);
    }
}
