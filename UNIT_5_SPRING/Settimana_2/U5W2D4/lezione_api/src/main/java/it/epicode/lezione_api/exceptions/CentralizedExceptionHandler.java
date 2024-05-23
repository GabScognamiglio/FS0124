package it.epicode.lezione_api.exceptions;

import it.epicode.lezione_api.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudenteNonTrovatoException.class)
    public ResponseEntity<Object> studenteNonTrovatoHandler (StudenteNonTrovatoException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AulaNonTrovataException.class)
    public ResponseEntity<Object> aulaNonTrovataHandler (AulaNonTrovataException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestHandler (BadRequestException e) {
        Error error = new Error();
        error.setMessage(e.getMessage());
        error.setDate(LocalDateTime.now());
        error.setStatus(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
