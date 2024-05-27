package it.epicode.gestione_dispositivi.controller;

import it.epicode.gestione_dispositivi.dto.SmartphoneDto;
import it.epicode.gestione_dispositivi.exception.BadRequestException;
import it.epicode.gestione_dispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Smartphone;
import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import it.epicode.gestione_dispositivi.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;

    @PostMapping("api/smartphones")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveSmartphone(@RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
        return smartphoneService.saveSmartphone(smartphoneDto);
    }

    @GetMapping("api/smartphones")
    public Page<Smartphone> getSmartphones(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size,
                                           @RequestParam(defaultValue = "id") String sortBy) {
        return smartphoneService.getSmartphones(page, size, sortBy);
    }

    @GetMapping("api/smartphones/{id}")
    public Smartphone getSmartphoneById(@PathVariable int id) {
        Optional<Smartphone> smartphoneOptional = smartphoneService.getSmartphoneById(id);
        if (smartphoneOptional.isPresent()) {
            return smartphoneOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato");
        }
    }

    @PutMapping("/api/smartphones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Smartphone updateSmartphone(@PathVariable int id, @RequestBody @Validated SmartphoneDto smartphoneDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return smartphoneService.updateSmartphone(id, smartphoneDto);
    }

    @DeleteMapping("/api/smartphones/{id}")
    public String deleteSmartphone(@PathVariable int id) {
        return smartphoneService.deleteSmartphone(id);
    }

    @PatchMapping("/api/smartphones/{id}")
    public String patchStatoSmartphone(@PathVariable int id, @RequestParam StatoDispositivo statoDispositivo) {
        return smartphoneService.patchStatoSmartphone(id, statoDispositivo);
    }


}
