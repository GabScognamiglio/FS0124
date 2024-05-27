package it.epicode.gestione_dispositivi.controller;

import it.epicode.gestione_dispositivi.dto.DipendenteDto;
import it.epicode.gestione_dispositivi.dto.DipendenteLoginDto;
import it.epicode.gestione_dispositivi.exception.BadRequestException;
import it.epicode.gestione_dispositivi.service.AuthService;
import it.epicode.gestione_dispositivi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    public class AuthController {

        @Autowired
        private AuthService authService;

        @Autowired
        private DipendenteService dipendenteService;

        @PostMapping("/auth/register")
        public String register(@RequestBody @Validated DipendenteDto dipendenteDto, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new BadRequestException(bindingResult.getAllErrors()
                        .stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + s2));
            }
            return dipendenteService.saveDipendente(dipendenteDto);
        }

        @PostMapping("/auth/login")
        public String login(@RequestBody @Validated DipendenteLoginDto dipendenteLoginDto, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new BadRequestException(bindingResult.getAllErrors()
                        .stream().map(e -> e.getDefaultMessage()).reduce("", (s1, s2) -> s1 + s2));
            }

            return authService.authenticateDipendenteAndCreateToken(dipendenteLoginDto);
        }
    }

