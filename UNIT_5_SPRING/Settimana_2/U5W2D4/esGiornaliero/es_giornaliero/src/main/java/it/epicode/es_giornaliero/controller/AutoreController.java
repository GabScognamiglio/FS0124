package it.epicode.es_giornaliero.controller;


import it.epicode.es_giornaliero.dto.AutoreDto;
import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.exception.BadRequestException;
import it.epicode.es_giornaliero.model.Autore;
import it.epicode.es_giornaliero.service.AutoreService;
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
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @PostMapping("api/autori")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAutore(@RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
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
    public Autore updateAutore(@PathVariable int id, @RequestBody @Validated AutoreDto autoreDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return autoreService.updateAutore(id, autoreDto);
    }

    @DeleteMapping("/api/autori/{id}")
    public String deleteAutore(@PathVariable int id) {
        return autoreService.deleteAutore(id);
    }

    @PatchMapping("/api/autori/{id}")
    public String patchAvatarAutore(@PathVariable int id, @RequestBody MultipartFile img) throws IOException {
        return autoreService.patchAvatarAutore(id, img);
    }
}