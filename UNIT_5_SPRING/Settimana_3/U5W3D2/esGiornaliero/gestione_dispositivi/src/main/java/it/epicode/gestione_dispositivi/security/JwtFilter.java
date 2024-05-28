package it.epicode.gestione_dispositivi.security;

import it.epicode.gestione_dispositivi.exception.DipendenteNonTrovatoException;
import it.epicode.gestione_dispositivi.exception.UnauthorizedException;
import it.epicode.gestione_dispositivi.model.Dipendente;
import it.epicode.gestione_dispositivi.service.DipendenteService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.DataInput;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private DipendenteService dipendenteService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UnauthorizedException("Error in authorization, token missing!");
        }

        String token = authHeader.substring(7);

        jwtTool.verifyToken(token);

        //estraggo dal token l'id utente
        int dipendenteId = jwtTool.getIdFromToken(token);
        Optional<Dipendente> dipendenteOptional = dipendenteService.getDipendenteById(dipendenteId);

        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();

            //per far sapere all'app che l'utente è autenticato e ha le sue autorizzazioni (USER o ADMIN)
            Authentication authentication = new UsernamePasswordAuthenticationToken(dipendente, null, dipendente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new DipendenteNonTrovatoException("Dipendente con id; " + dipendenteId + " non trovato.");
        }

        filterChain.doFilter(request, response);
    }


    //per permettere login e registrazione senza token
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return new AntPathMatcher().match("/api/dipendenti/auth/**", request.getServletPath());
    }
}
