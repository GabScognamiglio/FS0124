package it.epicode.gestione_dispositivi.controller;


import it.epicode.gestione_dispositivi.dto.DipendenteDto;
import it.epicode.gestione_dispositivi.exception.BadRequestException;
import it.epicode.gestione_dispositivi.exception.DipendenteNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Dipendente;
import it.epicode.gestione_dispositivi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping("api/dipendenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveDipendente(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
        return dipendenteService.saveDipendente(dipendenteDto);
    }

    @GetMapping("api/dipendenti")
    public Page<Dipendente> getAutori(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "id") String sortBy) {
        return dipendenteService.getDipendenti(page, size, sortBy);
    }

    @GetMapping("api/dipendenti/{id}")
    public Dipendente getDipendenteById(@PathVariable int id) {
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {
            return dipendenteOptional.get();
        } else {
            throw new DipendenteNonTrovatoException("Dipendente non trovato");
        }
    }

    @PutMapping("/api/dipendenti/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dipendente updateDipendente(@PathVariable int id, @RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return dipendenteService.updateDipendente(id, dipendenteDto);
    }

    @DeleteMapping("/api/dipendenti/{id}")
    public String deleteDipendente(@PathVariable int id) {
        return dipendenteService.deleteDipendente(id);
    }

    @PatchMapping("/api/dipendenti/{id}")
    public String patchImmagineProfiloDipendente(@PathVariable int id, @RequestBody MultipartFile immagineProfilo) throws IOException {
        return dipendenteService.patchImmagineProfiloDipendente(id, immagineProfilo);
    }

    @PatchMapping("/api/dipendenti-laptop/{dipendenteId}")
    public String patchLaptopDipendente(@PathVariable int dipendenteId, @RequestParam int laptopId) {
        return dipendenteService.patchLaptopDipendente(dipendenteId, laptopId);
    }

    @PatchMapping("/api/dipendenti-smartphone/{dipendenteId}")
    public String patchSmartphoneDipendente(@PathVariable int dipendenteId, @RequestParam int smartphoneId) {
        return dipendenteService.patchSmartphoneDipendente(dipendenteId, smartphoneId);
    }
}
