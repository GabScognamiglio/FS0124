package it.epicode.es_giornaliero.service;

import com.cloudinary.Cloudinary;
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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


@Service
public class AutoreService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AutoreRepository autoreRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public String saveAutore(AutoreDto autoreDto) {
        Autore autore = new Autore(autoreDto.getNome(),autoreDto.getCognome(), autoreDto.getDataNascita(), autoreDto.getEmail());
       autoreRepository.save(autore);
       sendMail(autore.getEmail());
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

    public String patchAvatarAutore (int id, MultipartFile img) throws IOException {
        Optional<Autore> autoreOptional = getAutoreById(id);

        if (autoreOptional.isPresent()) {
            String url =(String) cloudinary.uploader().upload(img.getBytes(), Collections.emptyMap()).get("url");
            Autore autore = autoreOptional.get();

            autore.setAvatar(url);
            autoreRepository.save(autore);
            return "Autore con id" + id + " aggiornato correttamente con l'immagine: " + url;
        }
        else {
            throw new AutoreNonTrovatoException("Autore con id " + id + " non trovato");
        }
    }

    private void sendMail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registrazione Autore nel Blog");
        message.setText("Complimenti! L'autore è stato registrato nel nostro Blog!");

        javaMailSender.send(message);
    }
}
