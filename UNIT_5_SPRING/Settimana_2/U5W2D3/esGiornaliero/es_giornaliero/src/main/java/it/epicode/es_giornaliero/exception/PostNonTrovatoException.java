package it.epicode.es_giornaliero.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNonTrovatoException extends RuntimeException{
    public PostNonTrovatoException(String message) {
        super(message);
    }
}
