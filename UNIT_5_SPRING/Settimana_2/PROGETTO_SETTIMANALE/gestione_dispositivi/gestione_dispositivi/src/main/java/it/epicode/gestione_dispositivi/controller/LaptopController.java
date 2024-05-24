package it.epicode.gestione_dispositivi.controller;


import it.epicode.gestione_dispositivi.dto.LaptopDto;
import it.epicode.gestione_dispositivi.exception.BadRequestException;
import it.epicode.gestione_dispositivi.exception.DispositivoNonTrovatoException;
import it.epicode.gestione_dispositivi.model.Laptop;
import it.epicode.gestione_dispositivi.model.StatoDispositivo;
import it.epicode.gestione_dispositivi.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping("api/laptops")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveLaptop(@RequestBody @Validated LaptopDto laptopDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors()
                    .stream().map(e -> e.getDefaultMessage()).reduce("", (s, a) -> s + a));
        }
        return laptopService.saveLaptop(laptopDto);
    }

    @GetMapping("api/laptops")
    public Page<Laptop> getLaptops(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "id") String sortBy) {
        return laptopService.getLaptops(page, size, sortBy);
    }

    @GetMapping("api/laptops/{id}")
    public Laptop getLaptopById(@PathVariable int id) {
        Optional<Laptop> laptopOptional = laptopService.getLaptopById(id);
        if (laptopOptional.isPresent()) {
            return laptopOptional.get();
        } else {
            throw new DispositivoNonTrovatoException("Dispositivo non trovato");
        }
    }

    @PutMapping("/api/laptops/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Laptop updateLaptop(@PathVariable int id, @RequestBody @Validated LaptopDto laptopDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).reduce("", ((s, s2) -> s + s2)));
        }

        return laptopService.updateLaptop(id, laptopDto);
    }

    @DeleteMapping("/api/laptops/{id}")
    public String deleteLaptop(@PathVariable int id) {
        return laptopService.deleteLaptop(id);
    }

    @PatchMapping("/api/laptops/{id}")
    public String patchStatoLaptop(@PathVariable int id, @RequestParam StatoDispositivo statoDispositivo) {
        return laptopService.patchStatoLaptop(id, statoDispositivo);
    }

}
