package it.epicode.es_giornaliero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AutoreNonTrovatoException extends RuntimeException{
    public AutoreNonTrovatoException(String message) {
        super(message);
    }
}
