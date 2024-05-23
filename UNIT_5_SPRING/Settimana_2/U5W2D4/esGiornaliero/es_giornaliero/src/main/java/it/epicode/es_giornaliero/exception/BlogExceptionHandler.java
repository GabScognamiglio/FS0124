package it.epicode.es_giornaliero.exception;

import it.epicode.es_giornaliero.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

public class BlogExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AutoreNonTrovatoException.class)
    public ResponseEntity<Object> AutoreNonTrovatoHandler (AutoreNonTrovatoException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
