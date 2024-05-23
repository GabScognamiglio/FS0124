package it.epicode.lezione_api.controller;

import it.epicode.lezione_api.dto.StudenteDto;
import it.epicode.lezione_api.exceptions.BadRequestException;
import it.epicode.lezione_api.exceptions.StudenteNonTrovatoException;
import it.epicode.lezione_api.model.Studente;
import it.epicode.lezione_api.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody @Validated StudenteDto studenteDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
        return studenteService.saveStudente(studenteDto);
    }


    @GetMapping("api/studenti")
    public Page<Studente> getAllStudenti(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "15") int size,
                                         @RequestParam(defaultValue = "matricola") String sortBy) {
        return studenteService.getStudenti(page, size, sortBy);
    }

    @GetMapping("api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola) {
        Optional<Studente> studenteOptional = studenteService.getStudenteById(matricola);
        if (studenteOptional.isPresent()) {
            return studenteOptional.get();
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato");
        }
    }

    @PutMapping("/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)
    public Studente updateStudente(@PathVariable int matricola, @RequestBody @Validated StudenteDto studente, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
        return studenteService.updateStudente(matricola, studente);
    }


    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola) {
        return studenteService.deleteStudente(matricola);
    }

    @PatchMapping("/api/studenti/{matricola}")
    public String patchFotoStudente(@PathVariable int matricola, @RequestBody MultipartFile img) throws IOException {
        return studenteService.patchFotoStudente(matricola, img);
    }
}
