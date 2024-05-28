package it.epicode.gestione_dispositivi.service;

import it.epicode.gestione_dispositivi.dto.DipendenteLoginDto;
import it.epicode.gestione_dispositivi.exception.UnauthorizedException;
import it.epicode.gestione_dispositivi.model.Dipendente;
import it.epicode.gestione_dispositivi.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private JwtTool jwtTool;

    public String authenticateDipendenteAndCreateToken(DipendenteLoginDto dipendenteLoginDto){
        Dipendente dipendente = dipendenteService.getDipendenteByEmail(dipendenteLoginDto.getEmail());

        if (dipendente.getPassword().equals(dipendenteLoginDto.getPassword())) {
            return jwtTool.createToken(dipendente);
        }
        else {
            throw new UnauthorizedException("Wrong password!");
        }
    }
}
