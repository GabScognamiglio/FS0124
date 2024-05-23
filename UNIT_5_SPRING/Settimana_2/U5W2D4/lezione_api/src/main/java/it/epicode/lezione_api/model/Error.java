package it.epicode.lezione_api.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Error {
    private String message;
    private LocalDateTime date;
    private HttpStatus status;
}
