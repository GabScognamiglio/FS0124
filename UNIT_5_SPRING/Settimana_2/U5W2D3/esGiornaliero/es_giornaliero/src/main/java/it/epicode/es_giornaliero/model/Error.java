package it.epicode.es_giornaliero.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class Error {

    private String message;
    private LocalDateTime date;
    private HttpStatus status;
}
