package it.epicode.lezione_api.controller;


import it.epicode.lezione_api.dto.AulaDto;
import it.epicode.lezione_api.exceptions.AulaNonTrovataException;
import it.epicode.lezione_api.exceptions.BadRequestException;
import it.epicode.lezione_api.model.Aula;
import it.epicode.lezione_api.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @PostMapping("api/aule")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveAula(@RequestBody @Validated AulaDto aulaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e->e.getDefaultMessage()).reduce("", (s, a) -> s + a ));
        }
        return aulaService.saveAula(aulaDto);
    }

    @GetMapping("api/aule")
    public List<Aula> getAule() {
        return aulaService.getAule();
    }

    @GetMapping("api/aule/{id}")
    public Aula getAulaById(@PathVariable int id) {
        Optional<Aula> aulaOptional = aulaService.getAulaById(id);
        if (aulaOptional.isPresent()) {
            return aulaOptional.get();
        } else {
            throw new AulaNonTrovataException("Aula non trovato");
        }
    }

    @PutMapping("/api/aule/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aula updateAula(@PathVariable int id, @RequestBody @Validated AulaDto aulaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e->e.getDefaultMessage()).reduce("", (s, a) -> s + a ));
        }
        return aulaService.updateAula(id, aulaDto);
    }

    @DeleteMapping("/api/aule/{id}")
    public String deleteAula(@PathVariable int id) {
        return aulaService.deleteAula(id);
    }



}
