package it.epicode.es_giornaliero.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class AutoreDto {
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
}
