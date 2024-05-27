package it.epicode.gestione_dispositivi.service;

import it.epicode.gestione_dispositivi.dto.LaptopDto;
import it.epicode.gestione_dispositivi.dto.LaptopDto;
import it.epicode.gestione_dispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Laptop;

import it.epicode.gestione_dispositivi.model.Smartphone;
import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import it.epicode.gestione_dispositivi.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public String saveLaptop(LaptopDto laptopDto) {
        Laptop laptop = new Laptop();
        laptop.setMarca(laptopDto.getMarca());
        laptop.setModello((laptopDto.getModello()));
        laptop.setPolliciSchermo(laptopDto.getPolliciSchermo());
        laptop.setStatoDispositivo(StatoDispositivo.valueOf(laptopDto.getStatoDispositivo()));
        laptop.setRam(laptopDto.getRam());
        laptop.setSsd(laptopDto.getSsd());

        laptopRepository.save(laptop);
        return "Laptop con ID " + laptop.getId() + " creato con successo.";
    }

    public Page<Laptop> getLaptops(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return laptopRepository.findAll(pageable);
    }

    public Optional<Laptop> getLaptopById(int id) {
        return laptopRepository.findById(id);
    }

    public Laptop updateLaptop(int id, LaptopDto laptopDto) {
        Optional<Laptop> laptopOptional = getLaptopById(id);

        if (laptopOptional.isPresent()) {
            Laptop laptop = laptopOptional.get();
            laptop.setMarca(laptopDto.getMarca());
            laptop.setModello((laptopDto.getModello()));
            laptop.setPolliciSchermo(laptopDto.getPolliciSchermo());
            laptop.setStatoDispositivo(StatoDispositivo.valueOf(laptopDto.getStatoDispositivo()));
            laptop.setRam(laptopDto.getRam());
            laptop.setSsd(laptopDto.getSsd());

            laptopRepository.save(laptop);
            return laptop;
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

    public String deleteLaptop(int id) {
        Optional<Laptop> laptopOptional = getLaptopById(id);

        if (laptopOptional.isPresent()) {
            laptopRepository.delete(laptopOptional.get());
            return "Laptop con id" + id + " eliminato con successo.";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

    //metodo per fare la patch del solo STATO del dispositivo(   DISPONIBILE, ASSEGNATO, IN_MANUTENZIONE, DISMESSO)
    public String patchStatoLaptop(int id, StatoDispositivo statoDispositivo) {
        Optional<Laptop> laptopOptional = getLaptopById(id);
        if (laptopOptional.isPresent()) {
            Laptop laptop = laptopOptional.get();
            laptop.setStatoDispositivo(statoDispositivo);
            laptopRepository.save(laptop);
            return "Stato dello Laptop con id" + id + " aggiornato con successo.";
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo con id " + id + " non trovato");
        }
    }

}
