package it.epicode.gestione_dispositivi.service;


import it.epicode.gestione_dispositivi.dto.SmartphoneDto;
import it.epicode.gestione_dispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Smartphone;
import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import it.epicode.gestione_dispositivi.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService {
    @Autowired
    private SmartphoneRepository smartphoneRepository;

    public String saveSmartphone(SmartphoneDto smartphoneDto) {
        Smartphone smartphone = new Smartphone();
        smartphone.setMarca(smartphoneDto.getMarca());
        smartphone.setModello((smartphoneDto.getModello()));
        smartphone.setPolliciSchermo(smartphoneDto.getPolliciSchermo());
        smartphone.setStatoDispositivo(StatoDispositivo.valueOf(smartphoneDto.getStatoDispositivo()));
        smartphone.setMegapixel(smartphoneDto.getMegapixel());

        smartphoneRepository.save(smartphone);
        return "Smartphone con ID " + smartphone.getId() + " creato con successo.";
    }

    public Page<Smartphone> getSmartphones(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return smartphoneRepository.findAll(pageable);
    }

    public Optional<Smartphone> getSmartphoneById(int id) {
        return smartphoneRepository.findById(id);
    }

    public Smartphone updateSmartphone(int id, SmartphoneDto smartphoneDto) {
        Optional<Smartphone> smartphoneOptional = getSmartphoneById(id);

        if (smartphoneOptional.isPresent()) {
            Smartphone smartphone = smartphoneOptional.get();
            smartphone.setMarca(smartphoneDto.getMarca());
            smartphone.setModello((smartphoneDto.getModello()));
            smartphone.setPolliciSchermo(smartphoneDto.getPolliciSchermo());
            smartphone.setStatoDispositivo(StatoDispositivo.valueOf(smartphoneDto.getStatoDispositivo()));
            smartphone.setMegapixel(smartphoneDto.getMegapixel());

            smartphoneRepository.save(smartphone);
            return smartphone;
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

    public String deleteSmartphone(int id) {
        Optional<Smartphone> smartphoneOptional = getSmartphoneById(id);

        if (smartphoneOptional.isPresent()) {
            smartphoneRepository.delete(smartphoneOptional.get());
            return "Smartphone con id" + id + " eliminato con successo.";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

    //metodo per fare la patch del solo STATO del dispositivo(   DISPONIBILE, ASSEGNATO, IN_MANUTENZIONE, DISMESSO)
    public String patchStatoSmartphone(int id, StatoDispositivo statoDispositivo) {
        Optional<Smartphone> smartphoneOptional = getSmartphoneById(id);
        if (smartphoneOptional.isPresent()) {
            Smartphone smartphone = smartphoneOptional.get();
            smartphone.setStatoDispositivo(statoDispositivo);
            smartphoneRepository.save(smartphone);
            return "Stato dello Smartphone con id" + id + " aggiornato con successo.";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

}
