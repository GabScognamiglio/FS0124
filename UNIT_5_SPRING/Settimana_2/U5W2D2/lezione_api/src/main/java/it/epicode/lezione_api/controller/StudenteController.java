package it.epicode.lezione_api.controller;

import it.epicode.lezione_api.exceptions.StudenteNonTrovatoException;
import it.epicode.lezione_api.model.Studente;
import it.epicode.lezione_api.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @PostMapping("api/studenti")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveStudente(@RequestBody Studente studente) {
        return studenteService.saveStudente(studente);
    }


    @GetMapping("api/studenti")
    public List<Studente> getAllStudenti() {
        return studenteService.getAllStudenti();
    }

    @GetMapping("api/studenti/{matricola}")
    public Studente getStudenteByMatricola(@PathVariable int matricola) throws StudenteNonTrovatoException {
        Optional<Studente> studenteOptional = studenteService.getStudenteByMatricola(matricola);
        if (studenteOptional.isPresent()) {
            return studenteOptional.get();
        } else {
            throw new StudenteNonTrovatoException("Studente non trovato");
        }
    }

    @PutMapping("/api/studenti/{matricola}")
    @ResponseStatus(HttpStatus.OK)
    public Studente updateStudente(@PathVariable int matricola, @RequestBody Studente studente) throws StudenteNonTrovatoException {
        return studenteService.updateStudente(matricola, studente);
    }


    @DeleteMapping("/api/studenti/{matricola}")
    public String deleteStudente(@PathVariable int matricola) throws StudenteNonTrovatoException {
       return studenteService.deleteStudente(matricola);
    }


//    @GetMapping("/api")
//    public String benvenuto() {
//        return "Benvenuto Gab";
//    }
//
//    //gestisce chiamate con query params "nome" e "cognome"
//    @GetMapping("/api/nome_cognome")
//    public String benvenuto2(@RequestParam String nome, String cognome) {
//        return "Benvenuto " + nome + " " + cognome;
//    }
//
//    //path params
//    @GetMapping("/api/{nome}/{cognome}")
//    public String benvenuto3(@PathVariable String nome, @PathVariable String cognome) {
//        return "Benvenuto " + nome.toUpperCase() + " " + cognome.toUpperCase();
//    }
//
//    //body della richiesta
//    @GetMapping("/api/body")
//    public String benvenuto4(@RequestBody Studente body) {
//        return "Benvenuto " + body.getNome() + " " + body.getCognome();
//    }


}
