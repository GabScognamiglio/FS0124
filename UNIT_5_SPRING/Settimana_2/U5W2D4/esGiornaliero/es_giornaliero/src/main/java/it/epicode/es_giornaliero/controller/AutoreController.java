package it.epicode.es_giornaliero.controller;


import it.epicode.es_giornaliero.dto.AutoreDto;
import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.model.Autore;
import it.epicode.es_giornaliero.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @PostMapping("api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody AutoreDto autoreDto) {
        return autoreService.saveAutore(autoreDto);
    }

    @GetMapping("api/autori")
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "15") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return autoreService.getAutori(page, size, sortBy);
    }

    @GetMapping("api/autori/{id}")
    public Autore getAutoreById(@PathVariable int id) {
        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);
        if (autoreOptional.isPresent()) {
            return autoreOptional.get();
        } else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    @PutMapping("/api/autori/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore updateAutore(@PathVariable int id, @RequestBody AutoreDto autoreDto) {
        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) {
        return autoreService.deleteAutore(id);
    }
}
