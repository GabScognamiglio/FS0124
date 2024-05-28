package it.epicode.gestione_dispositivi.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import it.epicode.gestione_dispositivi.exception.UnauthorizedException;
import it.epicode.gestione_dispositivi.model.Dipendente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class JwtTool {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.duration}")
    private long duration;


    public String createToken(Dipendente dipendente) {
        return Jwts.builder().issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + duration))
                .subject(String.valueOf(dipendente.getId()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }

    //effettua la verifica del token ricevuto
    public void verifyToken(String token) {

        try {
            Jwts.parser()
                    .verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                    .build()
                    .parse(token);
        } catch (Exception e) {
            throw new UnauthorizedException("Error in authorization, please relogin!");
        }
    }

    //decodificare il token ed estrarre id; il parseInt seve per trasformare la stringa in int
    public int getIdFromToken(String token){
        return Integer.parseInt(Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject());
    }
}
