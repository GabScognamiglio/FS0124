package it.epicode.es_giornaliero.controller;


import it.epicode.es_giornaliero.exception.AutoreNonTrovatoException;
import it.epicode.es_giornaliero.model.Autore;
import it.epicode.es_giornaliero.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutoreController {

    @Autowired
    private AutoreService autoreService;


    @GetMapping("api/authors")
    public List<Autore> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @GetMapping("api/authors/{id}")
    public Autore getAutoreById(@PathVariable int id) throws AutoreNonTrovatoException {
        Optional<Autore> autoreOptional = autoreService.getAutoreById(id);
        if (autoreOptional.isPresent()){
            return autoreOptional.get();
        }
        else {
            throw new AutoreNonTrovatoException("Autore non trovato");
        }
    }

    @PostMapping("api/authors")
    public String saveAutore(@RequestBody Autore autore){
        return autoreService.saveAutore(autore);
    }

    @PutMapping("api/authors/{id}")
    public Autore updateAutore(@PathVariable int id, @RequestBody Autore autore) throws AutoreNonTrovatoException{
        return autoreService.updateAutore(id, autore);
    }

    @DeleteMapping("api/authors/{id}")
    public String deleteAutore(@PathVariable int id) throws AutoreNonTrovatoException{
        return autoreService.deleteAutore(id);
    }

}
