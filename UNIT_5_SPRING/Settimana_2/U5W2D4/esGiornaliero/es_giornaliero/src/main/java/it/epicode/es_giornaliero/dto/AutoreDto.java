package it.epicode.es_giornaliero.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;


@Data
public class AutoreDto {
    @NotNull
    @Size(max = 30)
    private String nome;
    @NotNull
    @Size(max = 30)
    private String cognome;
    @Email
    private String email;
    private LocalDate dataNascita;
}
