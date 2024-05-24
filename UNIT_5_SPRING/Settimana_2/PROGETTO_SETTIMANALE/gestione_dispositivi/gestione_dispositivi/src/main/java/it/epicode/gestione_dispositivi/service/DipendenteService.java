package it.epicode.gestione_dispositivi.service;

import com.cloudinary.Cloudinary;
import it.epicode.gestione_dispositivi.dto.DipendenteDto;
import it.epicode.gestione_dispositivi.dto.SmartphoneDto;
import it.epicode.gestione_dispositivi.exception.DipendenteNonTrovatoException;
import it.epicode.gestione_dispositivi.exception.DispositivoNonAssegnabileException;
import it.epicode.gestione_dispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Dipendente;
import it.epicode.gestione_dispositivi.model.Laptop;
import it.epicode.gestione_dispositivi.model.Smartphone;
import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import it.epicode.gestione_dispositivi.repository.DipendenteRepository;
import it.epicode.gestione_dispositivi.repository.LaptopRepository;
import it.epicode.gestione_dispositivi.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private Cloudinary cloudinary;

    public String saveDipendente(DipendenteDto dipendenteDto) {
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDto.getNome());
        dipendente.setCognome((dipendenteDto.getCognome()));
        dipendente.setUsername(dipendenteDto.getUsername());
        dipendente.setEmail(dipendenteDto.getEmail());

        dipendenteRepository.save(dipendente);
        return "Dipendente con ID " + dipendente.getId() + " creato con successo.";
    }

    public Page<Dipendente> getDipendenti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return dipendenteRepository.findAll(pageable);
    }

    public Optional<Dipendente> getDipendenteById(int id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente updateDipendente(int id, DipendenteDto dipendenteDto) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setNome(dipendenteDto.getNome());
            dipendente.setCognome((dipendenteDto.getCognome()));
            dipendente.setUsername(dipendenteDto.getUsername());
            dipendente.setEmail(dipendenteDto.getEmail());

            dipendenteRepository.save(dipendente);
            return dipendente;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id " + id + " non trovato");
        }
    }

    public String deleteDipendente(int id) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            dipendenteRepository.delete(dipendenteOptional.get());
            return "Dipendente con id" + id + " eliminato con successo.";
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id " + id + " non trovato");
        }
    }

    public String patchImmagineProfiloDipendente(int id, MultipartFile immagineProfilo) throws IOException {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(id);

        if (dipendenteOptional.isPresent()) {
            String url = (String) cloudinary.uploader().upload(immagineProfilo.getBytes(), Collections.emptyMap()).get("url");
            Dipendente dipendente = dipendenteOptional.get();

            dipendente.setImmagineProfilo(url);
            dipendenteRepository.save(dipendente);
            return "Dipendente con id" + id + " aggiornato correttamente con l'immagine: " + url;
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id " + id + " non trovato");
        }
    }


    //cerco dipendente e dispositivo con id, se ci sono e se il dispositivo è disponibile setto il dipendente allo smartphone e salvo
    public String patchSmartphoneDipendente(int dipendenteId, int smartphoneId) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(dipendenteId);
        Optional<Smartphone> smartphoneOptional = smartphoneRepository.findById(smartphoneId);

        if (dipendenteOptional.isPresent() && smartphoneOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            Smartphone smartphone = smartphoneOptional.get();


            if (smartphone.getStatoDispositivo() == StatoDispositivo.DISPONIBILE) {
                smartphone.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
                smartphone.setDipendente(dipendente);
                smartphoneRepository.save(smartphone);
                dipendenteRepository.save(dipendente);

                return "Smartphone con Id " + smartphone.getId() + " (" + smartphone.getMarca() + " "
                        + smartphone.getModello() + ") assegnato al dipendente con Id: " + dipendente.getId();
            } else {
                throw new DispositivoNonAssegnabileException("Dispositivo non assegnabile, controllare lo stato");
            }
        } else if (dipendenteOptional.isEmpty()) {
            throw new DipendenteNonTrovatoException("Dipendente con id " + dipendenteId + " non trovato");
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + smartphoneId + " non trovato");
        }
    }

    public String patchLaptopDipendente(int dipendenteId, int laptopId) {
        Optional<Dipendente> dipendenteOptional = getDipendenteById(dipendenteId);
        Optional<Laptop> laptopOptional = laptopRepository.findById(laptopId);

        if (dipendenteOptional.isPresent() && laptopOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            Laptop laptop = laptopOptional.get();

            if (laptop.getStatoDispositivo() == StatoDispositivo.DISPONIBILE) {
                laptop.setStatoDispositivo(StatoDispositivo.ASSEGNATO);
                laptop.setDipendente(dipendente);
                laptopRepository.save(laptop);
                dipendenteRepository.save(dipendente);
                return "Laptop con Id " + laptop.getId() + " (" + laptop.getMarca() + " "
                        + laptop.getModello() + ") assegnato al dipendente con Id: " + dipendente.getId();
            } else {
                throw new DispositivoNonAssegnabileException("Dispositivo non assegnabile, controllare lo stato");
            }

        } else if (dipendenteOptional.isEmpty()) {
            throw new DipendenteNonTrovatoException("Dipendente con id " + dipendenteId + " non trovato");
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + laptopId + " non trovato");
        }
    }


}
